import java.util.Scanner;

public class tic_tac {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                board[i][j] = ' ';
            }
        }
        System.out.println("\n\n\t\t\t-Tic Tac Toe-\n\n");
        System.out.println("NOTE: Please Enter the Row{1-3} & Column{1-3} in Order.\n\n");
        boolean gameover = false;
        char player = 'X';
        printboard(board);
        while (!gameover) {
            System.out.println("Turn For Player "+player+": ");
            int row = sc.nextInt();
            int cols = sc.nextInt();
            if(row >3 || row <1 || cols>3 || cols <1){
                System.out.println("Sorry! Invalid Input.");
                continue;
            }
            if(board[row-1][cols-1] != ' '){
                System.out.println("Sorry! Invalid Input.");
                continue;
            }
            board[row-1][cols-1] = player;
            System.out.println("\n");
            printboard(board);
            gameover = check(board, player,row-1,cols-1);
            if(gameover) System.out.println("\n\tWow! Player "+player+" has won the game.");
            player = (player == 'X')? 'O' : 'X';
        }
        sc.close();
    }

    private static boolean check(char[][] board, char player,int row, int cols) {
        int i=0;
        // checking in column
        for(i=0; i<board.length; i++){
            if(board[row][i] != player) break;
        }
        if(i == board.length) return true;
        // checking in row
        for(i=0; i<board.length; i++){
            if(board[i][cols] != player) break;
        }
        if(i == board.length) return true;
        // checking in diagonal
        if(board[1][1] != player) return false;
        if(board[0][0] == player && board[2][2]== player) return true;
        if(board[0][2] == player && board[2][0]== player) return true;
        return false;
    }

    private static void printboard(char[][] board) {
        for(int i=0; i<board.length; i++){
            System.out.print(" | ");
            for(int j=0; j<board[i].length; j++){
                System.out.print(board[i][j]+" | ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
