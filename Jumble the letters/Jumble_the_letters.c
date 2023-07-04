#include <stdio.h>
#include <time.h>
#include <conio.h>
#include <stdlib.h>
#include <string.h>

// this programme can hold 75 total word out of which 45 are set by the developers and remaining can be set by the user if they want
// These are the 45 words set by the developer....
char arr[75][15] = {"anaconda", "eagle", "papaya", "camel", "crab", "hen", "lamp", "snake", "goat", "apple", "zebra", "parrot", "rabbit", "horse", "bears", "frog", "tiger", "lion", "giraffe", "monkey", "donkey", "dolphin", "earthworm", "fox", "gorilla", "hyena", "jackal", "kangaroo", "kingfisher", "lizard", "mosquito", "ostrich", "octopus", "python", "penguin", "squirrel", "turtle", "vulture", "whale", "woodpecker", "mango", "lemon", "orange", "banana", "pomogranate"};

//declaring global variable for counting the no. of words in program as it can be increased as well if user adds more words.
int word_count;
//declaring file as a globally so that it can be opened in any of the function
FILE *fptr;

void account();  //function dealing with the registration of user that is required for setting up new words.
void login();    //function to login if the user have already registered and they can see their dashboard.
void addingwords(); //function for adding words in the globally declared arr 2-d array. 


//user-defined function to add delay before the execution of next line.
void delay(int number_of_seconds)
{
    // Storing start time and it use clock() function to store present time in start_time variable
    clock_t start_time = clock();
    // looping till required time is not achieved and till that time, the loop will do nothing
    while (clock() < start_time + number_of_seconds)
        ;
}

//declaring of structure for storing user credentials while registration
typedef struct user
{
    char name[25];
    long int mobile;
    char password[10];
} user;

//initialization of player variable of above declared structure
user player;

// This user-defined function will generate any random no. from the given range of lower-upper.
int random_no_generator(int lower, int upper)
{
    srand(time(NULL)); //srand will generate different random no. each time the function is called.
    int r = (rand() % (upper - lower + 1)) + lower; //rand() is inbuilt function to generate random no.
    return r;
}

//this function will jumble the letter of the words of provided index and uses concept of generating random no. for representing the index of letters in word.
int jumble(int a)
{
    delay(700);   //function call for delaying the execution of next line.
    printf("\t");
    char answer[15];  //for storing player's answer....
    int b, x;
    int length = strlen(arr[a]); //length of string whose index is passed by main function...
    int brr[length];  //creating array to store and check whether generated no. is repeated or not...

    for (int i = 0; i < length; i++)
    {
        brr[i] = i;
    }
    for (int i = length - 1; i > 0; i--)
    {
        b = random_no_generator(0, i);  //generating random no.
        x = brr[b];     //accessing the letter of index corresponding to the value stored in randomly generated index 
        printf("%c", arr[a][x]);

        //loop for deleting the generated value from that particular index to prevent from repition.. 
        for (int j = b; j < length - 1; j++)
        {
            brr[j] = brr[j + 1];
        }
        --length; //decreasing the length of string now finnaly after deleting one value from it..
    }
    x = brr[0];
    printf("%c", arr[a][x]);

    printf("\nYour Answer:  ");
    scanf("%s", &answer);
    delay(500);
    //comparing player's answer and accurate answer and returning the score accordingly...
    if (!strcmp(answer, arr[a]))
    {
        printf("Right answer!!\n\n");
        return 5;
    }
    else
    {
        printf("Wrong Anwer...............    Answer: %s\n\n", arr[a]);
        return 0;
    }
}

int main()
{
    word_count = 45; // this is the initial no. of strings set by developer which can be increased by the user later.
    int b, a, c, score, x, loop, again, log;
    do
    {
        score = 0;
        again = 0;
        // this is just for heading and decoration purpose......
        printf("\n\t\t\t\t SOLVE  JUMBLE WORDS\n\n");
        for (int i = 0; i < 85; i++)
        {
            printf("-");
        }
        printf("\n\n\n");

        //  No. of loops ie.- no. of words that the player wants to play with... out of total words(45).....
        printf("With how many words you wanna play?  ");
        scanf("%d", &loop);
        int w=word_count;
        printf("\n\n");

        // here i have defined new array with the size of no. of strings in the program to access the string of particular index corresponding to the value stored in index generated randomly, in 'brr' array and then deleting the particular value from that array to prevent from repitition.....
        int brr[word_count];
        for (int i = 0; i < word_count; i++)
        {
            brr[i] = i;
        }

        printf("Arrange The Given Jumble Words.......\n\n");
        for (int i = 0; i <loop; i++)
        {
            a = random_no_generator(0, w-1-i);
            x = brr[a];
            //this loop will delete the value of particular index generated randomly...
            for (int j = a; j < w - 1; j++)
            {
                brr[j] = brr[j + 1];
            }
            w--;    //reducing array size after deleting one element...
            c = jumble(x);   //passing the randomly generated index of any string to jumble function for jumbling it...
            score = score + c;
        }
        //printing the score..
        printf("\n\nYour score is %d out of %d.\n\n", score, loop * 5);
        delay(2000);
        do
        {
            printf("Wanna Play Again? ....   OR   ..... Set More Words In The System\n");
            delay(280);
            printf("Press 1 To play again....\nPress 2 To set more words.... \nPress 0 To exit...\n");
            scanf("%d", &again);
            switch (again)
            {
            case 1:
                delay(800);
                system("CLS");
                break;
            case 2:
                delay(1700);
                system("CLS");
                printf("Press 1 To Log In...\n");
                printf("Press 2 To Create an account...\n");
                scanf("%d", &log);
                delay(1500);
                if (log == 1)
                    login();
                else
                    account();
                break;
            default:
                system("CLS");
                printf("\n\n");
                exit(0);
            }
        } while (again == 2);
    } while (again == 1);
    return 0;
}

void account()
{
    system("CLS"); //clearing the display
    fptr = fopen("project.txt", "a");   //opening the file for storing user's credentials....
    printf("\t\t\t\t ACCOUNT SET-UP PAGE \n\n");
    //decoration....
    for (int i = 0; i < 85; i++)
    {
        printf("-");
    }
    printf("\n\n\n");

    printf("\nEnter your Name:  ");
    scanf("%s", &player.name);   //taking input from user
    fprintf(fptr, "Name:  %s\n", player.name);   //writing all the datas in file..
    printf("\nEnter your Mobile No.:  ");
    scanf("%ld", &player.mobile);
    fprintf(fptr, "Mobile No.:  %ld\n", player.mobile);
    printf("Create any Password of Less Than 8:  ");
    scanf("%s", &player.password);
    fprintf(fptr, "Password:  %s\n", player.password);
    fprintf(fptr, "\n");
    fclose(fptr);   //closing the file....
    delay(800);
    printf("\n\n\tCongratulation! Your Account has been successfully Registered.\n");
    delay(2000);
    printf("\nRedirecting U to LOGIN Page.");
    delay(500);
    printf(".");
    delay(350);
    printf(".");
    delay(550);
    printf(".");
    delay(400);
    login();
}

void login()
{
    system("CLS");  //clearing the output screen....
    long int a;
    char b[10];
    //decoration purposes....
    printf("\t\t\t\t LOGIN PAGE \n\n");
    for (int i = 0; i < 85; i++)
    {
        printf("-");
    }
    printf("\n\n\n");

    printf("\nEnter your Mobile No.:  ");
    scanf("%ld", &a);
    printf("\nEnter your Password:  ");
    scanf("%s", &b);
    printf("\nVerifying.");
    delay(400);
    printf(".");
    delay(650);
    printf(".");
    delay(850);
    printf(".");
    delay(350);
    if (a == player.mobile && !(strcmp(b, player.password)))
    {
        printf("\n\n\tWoW! You have successfully logged in...\n\n");
        delay(2750);
        addingwords();
    }
    else
    {
        printf("\n\n\tSorry! No Such Credentials Found....\nYou need to create an account first.\n");
        delay(150);
        printf("\nRedirecting U to New User Page.");
        delay(600);
        printf(".");
        delay(550);
        printf(".");
        delay(850);
        printf(".");
        delay(300);
        account();
    }
}

void addingwords()
{
    system("CLS");
    printf("\t\t\t\t DASHBOARD \n\n");
    int add;
    //decoration purposes...
    for (int i = 0; i < 85; i++)
    {
        printf("-");
    }
    printf("\n\n\n");

    printf("\tInitially Total Words Count in this Program is: %d.\n", word_count);
    delay(30);
    printf("\nHow many words you wanna add more in the program??\n");
    scanf("%d", &add);
    int tem = word_count;
    word_count += add;
    printf("\nStart Adding Your Words....\n");
    for (int j = tem; j < word_count; j++)
    {
        printf("Enter your word no.-%d:   ", j - tem + 1);
        scanf("%s", &arr[j]);
        printf("\n");
    }
    printf("\n\tYour have successfully added your %d words.\n", add);
    delay(50);
    printf("Now The Total Words Count in this Program is: %d\n", word_count);
    delay(1500);
    printf("\nRedirecting U to Your Home Page.");
    delay(400);
    printf(".");
    delay(650);
    printf(".");
    delay(850);
    printf(".");
    delay(350);
    system("CLS");
}