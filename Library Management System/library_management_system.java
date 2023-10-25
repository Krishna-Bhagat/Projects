import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class library {
    static Set<ArrayList<String>> books = new HashSet<ArrayList<String>>();
    static Set<ArrayList<String>> issue_details = new HashSet<ArrayList<String>>();

    public static void addbooks() {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> arr = new ArrayList<String>();
        System.out.print("Enter the name of the Book:\t");
        arr.add(sc.nextLine());
        System.out.print("Enter the Book ID:\t");
        arr.add(sc.nextLine());
        System.out.print("How many author are there for this book:\t");
        arr.add(sc.nextLine());
        for (int i = 0; i < Integer.parseInt(arr.get(2)); i++) {
            System.out.print("Enter the name of the author " + (i + 1) + ":\t");
            arr.add(sc.nextLine());
        }
        System.out.print("Enter the total number of Books in Libarary:\t");
        arr.add(sc.nextLine());
        books.add(arr);
    }

    public static void display_all_books() {
        if (books.size() == 0) {
            System.out.println("No More Books in Library.....");
        } else {
            for (int i = 0; i < books.size(); i++) {
                library.display_one_book(i);
            }
        }
    }

    public static void search_book() {
        Scanner scn = new Scanner(System.in);
        System.out.println("\nWanna Search By: Book Name /Book ID");
        System.out.println("Press <1> For Searching By Name");
        System.out.println("Press <2> For Searching By ID");
        int option = scn.nextInt();
        int count = 0;
        scn.nextLine();
        String reference;
        switch (option) {
            case 1:
                System.out.print("Enter the name of the Book:\t");
                reference = scn.nextLine();
                int i = 0;
                System.out.println();
                for (ArrayList<String> obj : books) {
                    if (obj.get(0).equalsIgnoreCase(reference)) {
                        library.display_one_book(i);
                        count++;
                        break;
                    }
                    i++;
                }
                break;
            case 2:
                System.out.print("Enter the ID of the Book:\t");
                reference = scn.nextLine();
                int j = 0;
                System.out.println();
                for (ArrayList<String> obj : books) {
                    if (obj.get(1).equalsIgnoreCase(reference)) {
                        library.display_one_book(j);
                        count++;
                        break;
                    }
                    j++;
                }
        }
        if (count == 0)
            System.out.println("Sorry! No records Found...");
    }

    public static void display_one_book(int index) {
        Scanner s = new Scanner(System.in);
        ArrayList<ArrayList<String>> arr = new ArrayList<ArrayList<String>>(books);
        System.out.println("Name of the Book:  " + arr.get(index).get(0));
        System.out.println("Book ID:  " + arr.get(index).get(1));
        System.out.println("Author of Book:-");
        int i;
        for (i = 0; i < Integer.parseInt(arr.get(index).get(2)); i++) {
            System.out.println((i + 1) + "> " + arr.get(index).get(3 + i));
        }
        System.out.println("Total Number of Books:  " + arr.get(index).get(3 + i));
        System.out.println("\n");
        System.out.println("Wanna Issue it?[y/n]");
        String opt = s.nextLine();
        if (opt.equalsIgnoreCase("Y"))
            library.issue_main_book(index);
    }

    public static int total_books() {
        return books.size();
    }

    public static void issue_book() {
        System.out.println("First, Check whether your your Book is available or not!");
        library.search_book();
    }

    public static void issue_main_book(int index) {
        Scanner main = new Scanner(System.in);
        ArrayList<ArrayList<String>> arr = new ArrayList<ArrayList<String>>(books);
        ArrayList<String> tem = new ArrayList<String>();
        tem.add(arr.get(index).get(0));
        tem.add(arr.get(index).get(1));
        System.out.print("Enter the name of the Student:  ");
        String name = main.nextLine();
        System.out.print("Enter his/her department:  ");
        String dept = main.nextLine();
        tem.add(name);
        tem.add(dept);
        issue_details.add(tem);
        int i = 0;
        int a = Integer.parseInt(arr.get(index).get(2));
        for (ArrayList<String> obj : books) {
            if (i == index) {
                int o = (Integer.parseInt(obj.get(a + 3)));
                String st = Integer.toString(--o);
                obj.set(a + 3, st);
                break;
            }
            i++;
        }
    }

    public static void issue_details() {
        if(issue_details.size()==0)System.out.println("No Books are issued till now.\n");
        for (ArrayList<String> obj : issue_details) {
            System.out.println("Name of the Book:\t" + obj.get(0));
            System.out.println("ID of the Book:\t" + obj.get(1));
            System.out.println("Name of the Student to whome Book is issued:\t" + obj.get(2));
            System.out.println("Name of the Department of Student:\t" + obj.get(3));
            System.out.println();
        }
    }

    public static void return_book() {
        Scanner ret = new Scanner(System.in);
        int count =0;
        ArrayList<ArrayList<String>> arr = new ArrayList<ArrayList<String>>(books);
        System.out.print("Enter the name of the Student:  ");
        String name = ret.nextLine();
        System.out.print("Enter his/her department:  ");
        String dept = ret.nextLine();
        System.out.print("Enter the name of the Book:   ");
        String book = ret.nextLine();
        System.out.print("Enter the ID of the Book:  ");
        String id = ret.nextLine();
        for (ArrayList<String> obj : books) {
            if (obj.get(0).equalsIgnoreCase(book) && obj.get(1).equalsIgnoreCase(id)) {
                int a = Integer.parseInt(obj.get(2));
                int o = Integer.parseInt(obj.get(a + 3));
                String st = Integer.toString(++o);
                obj.set(a + 3, st);
                count++;
                break;
            }
        }
        for (ArrayList<String> obj : issue_details) {
            if (obj.get(2).equalsIgnoreCase(name) && obj.get(3).equalsIgnoreCase(dept)) {
                issue_details.remove(obj);
                count++;
                break;
            }
        }
        if(count==0)System.out.println("\nCongratulation! This book is Yours From Now-Onwards.");
    }
}

public class library_management_system {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int option;
        while (true) {
            for (int i = 0; i < 30; i++)
                System.out.print("--");
            System.out.println("\nSelect Below Given Option & Press:");
            System.out.println("<1>  For Checking Total Number of Books in Library");
            System.out.println("<2>  For Displaying Details of all the Books in Library");
            System.out.println("<3>  For Adding any Book in Library");
            System.out.println("<4>  For Searching any Books");
            System.out.println("<5>  For Issuing any Book");
            System.out.println("<6>  For Returning any Book");
            System.out.println("<7>  For Displaying all Issue Details of Book\n");
            option = scan.nextInt();
            switch (option) {
                case 1:
                    System.out.println("\tTotal Number of Books in Library:- " + library.total_books());
                    break;
                case 2:
                    library.display_all_books();
                    break;
                case 3:
                    library.addbooks();
                    break;
                case 4:
                    library.search_book();
                    break;
                case 5:
                    library.issue_book();
                    break;
                case 6:
                    library.return_book();
                    break;
                case 7:
                    library.issue_details();
                    break;
                default:
                    System.exit(0);
            }
        }
    }
}