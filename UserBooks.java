import java.util.*;

class functions{
    static List<String> bookslist  = new LinkedList<>() ;
    public static void insertBooks(){
        Scanner sc = new Scanner(System.in);
        String input = new String();
        input = sc.nextLine();
        List<String> books = Arrays.asList(input.split(","));
        Collections.sort(books);
        for (String x : books){
            bookslist.add(x);
        }



    }

    public static void createlist(){

        Collections.sort(bookslist);
        System.out.println("Your booklist : "+bookslist);
    }



    public static void books (int option){

        switch (option){
            case 1:
                insertBooks();
                System.out.println();
                break;
            case 2:
                createlist();
                break;
            default :
                System.out.println("Please enter the correction option...");
        }


    }

}


public class UserBooks {

    public static void main (String args[]){

        System.out.println("");

        int n = 1;
        functions call = new functions();

        while (n!=0){
            System.out.println("Please select an option to procees:\n" +
                    "1 - to add books.\n" +
                    "2 - to display books.\n" +
                    "0 - to exit.\n");
            try{
                System.out.print("Enter your option : ");
                Scanner sc = new Scanner(System.in);
                n = sc.nextByte();
                if (n == 0){
                    System.out.println("Exiting...");
                    break;
                }

                else {
                    call.books(n);
                }
            }
            catch (Exception e){
                System.out.println("Please enter an option as mentioned above...\n");

            }

        }

    }
}
