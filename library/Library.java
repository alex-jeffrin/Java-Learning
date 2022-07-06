import Utilities.Utils;

import java.sql.*;
import java.util.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Library {
	static String jdbcURL = "jdbc:postgresql://localhost:5432/LibraryDatabase";
    static String username = "postgres";
    static String password = "root";
	static String sqlQuery;
    public static Connection connection;
	public static Statement statement ;
	
	
	static {
		try {
			connection = DriverManager.getConnection(jdbcURL,username,password );
		}
		catch(Exception e){
		}

	}
	static{
		try{
			statement = connection.createStatement();
		}
		catch(Exception e){
			
		}
	}


    public static void main (String args[]){
		
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy\thh:mm");
		String dateAndTime = formatter.format(date);
		sqlQuery = "INSERT INTO public.library_history (event_time, event,action) VALUES ('"+dateAndTime+"','Application has started','Open')";
		try{
			statement.executeUpdate(sqlQuery);
		}catch(Exception e){
			System.out.println(e);
		}
		         

        try {

            System.out.println("Database connection made successfully...");
            Utils.loadDB();
        } catch (Exception e) {
            System.out.println("Error in Database connection...");
        }

        Utils libraryMethods = new Utils();
        Utils.setBooksQuantity();

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
					sqlQuery = "INSERT INTO public.library_history (event_time, event,action) VALUES ('"+dateAndTime+"','Application has closed','Close')";
					try{
						statement.executeUpdate(sqlQuery);
						
					}
					catch(Exception e){
						System.out.println(e);
					}
					connection.close();
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
