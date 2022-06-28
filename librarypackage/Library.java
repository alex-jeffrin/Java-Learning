package librarypackage;

import java.text.SimpleDateFormat;
import java.util.*;

class Functions{
    static List<String> bookslist  = new LinkedList<>() ;
    static List<String> uniquebookslist = new LinkedList<>();
    static List<String> history = new LinkedList<>();




    public static void insertBooks(){
        Scanner sc = new Scanner(System.in);
        String input = new String();
        System.out.print("Enter book names : ");
        input = sc.nextLine();
        List<String> books = Arrays.asList(input.split(","));
        Collections.sort(books);
        for (String x : books){
            bookslist.add(x);
        }
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        String strDate= formatter.format(date);
        history.add(strDate+" Books added : "+books);
        createUniqueList();
    }

    public static void createUniqueList(){
        uniquebookslist.clear();
        for (String x :bookslist){
            if (uniquebookslist.contains(x)){
                continue;
            }
            else {
                uniquebookslist.add(x);
                Collections.sort(uniquebookslist);
            }
        }
    }


    public static void showBooks(){
        Collections.sort(bookslist);
        System.out.print("Your booklist : ");
        for (String x :uniquebookslist){
            System.out.print(x + "x" + Collections.frequency(bookslist,x)+", ");
        }
        System.out.println();
    }

    public static void borrowBook(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the book you want to borrow : ");
        String neededBook =  sc.nextLine();
        int count =0 ;
        if (bookslist.remove(neededBook)){
            System.out.println("Borrowed 1 book: "+neededBook);
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm");
            String strDate= formatter.format(date);
            history.add(strDate+" Books borrowed : "+neededBook);
        }
        else{
            System.out.println("Book out of stock");
        }
        createUniqueList();

    }


    public static void searchBook(){
        int count =0 ;
        Scanner sc = new Scanner(System.in);
        String keywords = sc.nextLine();
        System.out.print("Found books : ");
        for (String names : uniquebookslist)
            if(names.contains(keywords)){
                System.out.println(names);
                count++;
            }
        if(count ==0){
             System.out.println("None.");
        }
    }


    public static void viewHistory(){
        for (String x : history){
            System.out.println(x);
        }
        System.out.println();
    }


    public static void books (int option){
        switch (option){
            case 1:
                insertBooks();
                System.out.println();
                break;
            case 2:
                showBooks();
                System.out.println();
                break;
            case 3 :
                System.out.print("Enter keywords to search : ");
                searchBook();
                System.out.println();
                break;
            case 4:
                borrowBook();
                break;
            case 5:
                viewHistory();
                break;
            default :
                System.out.println("Please enter the correction option...");
        }
    }
}


public class Library {

    public static void main (String args[]){

        System.out.println("");

        int option = 1;
        Functions call = new Functions();

        while (option != 0){
            System.out.println("Please select an option to procees:\n" +
                    "1 - to add books.\n" +
                    "2 - to display books.\n" +
                    "3 - to Search.\n" +
                    "4 - to Borrow.\n" +
                    "5 - to view history.\n" +
                    "0 - to exit.\n");
            try{
                System.out.print("Enter your option : ");
                Scanner sc = new Scanner(System.in);
                option = sc.nextByte();
                if (option == 0){
                    System.out.println("Exiting...");
                    break;
                }

                else {
                    call.books(option);
                }
            }
            catch (Exception e){
                System.out.println("Please enter an option as mentioned above...\n");

            }
        }
    }
}
