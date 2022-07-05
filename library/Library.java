import Utilities.Utils;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;
import java.sql.Connection;

public class Library {

    public static void main (String args[]){

        String jdbcURL = "jdbc:postgresql://localhost:5432/LibraryDatabase";
        String username = "postgres";
        String password = "root";

        try {
            Connection connection = DriverManager.getConnection(jdbcURL,username,password   );
            System.out.println("Database connection made successfully...");
            Utils.loadDB();
        } catch (SQLException e) {
            System.out.println("Error in Database connection...");
            throw new RuntimeException(e);
        }

        Utils libraryMethods = new Utils();
        Utils.setBooksQUantity();

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
