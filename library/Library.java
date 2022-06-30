import java.util.*;

import Utilities.Utils;
import Utilities.BorrowThread;

public class Library {

    public static void main (String args[]){

        Utils libraryMethods = new Utils();
        libraryMethods.loadLibrary();
        Utils.getBooksQUantity();



        int option = 1;
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
                    libraryMethods.userOption(option);
                }
            }
            catch (Exception e){
                System.out.println("Please enter an option as mentioned above...\n");


            }
        }
    }
}
