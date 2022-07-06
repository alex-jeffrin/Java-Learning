package Utilities;


import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;


public class Utils {
    static List<String> booksList  = new LinkedList<>() ;
    static HashSet<String> uniqueBooksList = new HashSet<String>();
    static TreeMap<String,Integer> booksAndQunatity = new TreeMap<String, Integer>();
    static String bookInput = new String();
    static List<String> books = new ArrayList<>();
    static String neededBook;
    static String jdbcURL = "jdbc:postgresql://localhost:5432/LibraryDatabase";
    static String username = "postgres";
    static String password = "root";
    public static Connection connection;
	public static Statement statement;
	
	
    static {
        try {
            connection = DriverManager.getConnection(jdbcURL,username,password   );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
	static {
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
	
	
    public static void loadDB(){
        ResultSet queryResult = null;
        try {
            String loadQuery = "SELECT * FROM public.library_db";
            queryResult = statement.executeQuery(loadQuery);
            int booksloaded = 0;
            while (queryResult.next()){
                int i =queryResult.getInt(2);
                booksAndQunatity.put(queryResult.getString(1),i );
                uniqueBooksList.add(queryResult.getString(1));
                booksloaded++;
            }
            if (booksloaded<1){
                System.out.println("no books are available in DB");
            }
            else {
                System.out.println("Variety of books : "+booksloaded);
            }

        } catch (SQLException e) {
            System.out.println("could not reach db...");
        }
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy\thh:mm");
        String strDate= formatter.format(date);
    }


    public static void insertBooks() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter book names : ");
        bookInput = sc.nextLine();
        if (!bookInput.isEmpty()){
            books = Arrays.asList(bookInput.split(","));
            System.out.println(books);
            for (String x : books){
                booksList.add(x);
            }
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy\thh:mm");
            String strDate= formatter.format(date);
            String sqlQuery = "INSERT INTO public.library_history(event_time, event, action) VALUES ('"+strDate+ "','books added : "+books+"','Insert')";
            statement.executeUpdate(sqlQuery);
        }
        setBooksQuantity();
    }


    public static void setBooksQuantity(){
        for (String x :books)
            if (!uniqueBooksList.contains(x)){
                try {
                    String sqlQuery = "INSERT INTO public.library_db (book_name,book_quantity) VALUES ('"+x+"',1)";
                    int rows = statement.executeUpdate(sqlQuery);
                    if (rows>0){
                        System.out.println("book has been added...");
                    }
                } catch (SQLException e) {
                    System.out.println(e);
                }
                uniqueBooksList.add(x);
                booksAndQunatity.put((String) x,1);
//                System.out.println("in new collections "+booksAndQunatity);
            }
            else {
                booksAndQunatity.put(x, (booksAndQunatity.get(x))+1);
                try{
                    String sqlQuery = "UPDATE public.library_db SET book_quantity="+(booksAndQunatity.get(x))+" WHERE book_name='"+x+"';";
                    int rows = statement.executeUpdate(sqlQuery);
                    if (rows>0){
                        System.out.println("book has been added...");
                    }
                } catch (SQLException e) {
                    System.out.println();
                }
            }
    }


    public static void showBooks() throws SQLException {
        System.out.println(booksAndQunatity);
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy\thh:mm");
        String strDate= formatter.format(date);
        String sqlQuery = "INSERT INTO public.library_history(event_time, event, action) VALUES ('"+strDate+ "','Books viewed','View')";
        statement.executeUpdate(sqlQuery);
    }


    public static void searchBook() throws SQLException {
        int count =0 ;
        Scanner sc = new Scanner(System.in);
        String keywords = sc.nextLine();
        System.out.print("Found books : ");
        for (String names : uniqueBooksList)
            if(names.contains(keywords)){
                System.out.println(names);
                count++;
            }
        if(count ==0){
            System.out.println("None.");
        }
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy\thh:mm");
        String strDate= formatter.format(date);
        String sqlQuery = "INSERT INTO public.library_history(event_time, event, action) VALUES ('"+strDate+ "','Searched for book : "+keywords+"','Search')";
        statement.executeUpdate(sqlQuery);
    }


    public static void viewHistory() throws SQLException {
        Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy\thh:mm");
            String strDate= formatter.format(date);
            String sqlQuery = "INSERT INTO public.library_history(event_time, event, action) VALUES ('"+strDate+ "','Viewed history ','View')";
            statement.executeUpdate(sqlQuery);
            sqlQuery = "SELECT * FROM public.library_history";
			ResultSet queryResult = null;
			queryResult = statement.executeQuery(sqlQuery);
			while(queryResult.next()){
				System.out.print(queryResult.getString(1));
				System.out.print("\t"+queryResult.getString(2));
				System.out.print("\t("+queryResult.getString(3)+")");
				System.out.println();
			}
        System.out.println();
    }




    static synchronized public Boolean borrowMethod(String name){
        if (booksAndQunatity.get(neededBook) >0){
            booksAndQunatity.put(neededBook, (booksAndQunatity.get(neededBook))-1);
            try{
                String sqlQuery = "UPDATE public.library_db SET book_quantity="+(booksAndQunatity.get(neededBook))+" WHERE book_name='"+neededBook+"';";
                statement.executeUpdate(sqlQuery);
            } catch (SQLException e) {
                System.out.println();
            }
            System.out.println("A copy of "+ neededBook +" Has been borrowed by " +name );
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy\thh:mm");
            String strDate= formatter.format(date);
            String sqlQuery = "INSERT INTO public.library_history(event_time, event, action) VALUES ('"+strDate+ "','A copy of "+neededBook+" has been borrowed by "+name+"','Borrow')";
            try {
                statement.executeUpdate(sqlQuery);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return true;
        }
        else {
            return false;
        }
    }


    synchronized public static void returnMethod(String name) throws InterruptedException {
        Utils.booksAndQunatity.put(Utils.neededBook,(Utils.booksAndQunatity.get(Utils.neededBook))+1);
        try{
            String sqlQuery = "UPDATE public.library_db SET book_quantity="+(booksAndQunatity.get(neededBook))+" WHERE book_name='"+neededBook+"';";
            statement.executeUpdate(sqlQuery);
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy\thh:mm");
            String strDate= formatter.format(date);
            sqlQuery = "INSERT INTO public.library_history(event_time, event, action) VALUES ('"+strDate+ "','A copy of "+neededBook+"has been returned by "+name+"','Return')";
            try {
                statement.executeUpdate(sqlQuery);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            System.out.println();
        }
        System.out.println("a copy of "+neededBook+" has been returned by " + name);

    }


    public static void userOption (int option) throws SQLException {
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
                Scanner sc = new Scanner (System.in);
                System.out.print("Enter the Book name you want to borrow : ");
                neededBook = sc.nextLine();
                if (uniqueBooksList.contains(neededBook)){
                    BorrowThread custome1 = new BorrowThread("customer1");
                    BorrowThread custome2 = new BorrowThread("customer2");
                    BorrowThread custome3 = new BorrowThread("customer3");
                    BorrowThread custome4 = new BorrowThread("customer4");
                    BorrowThread custome5 = new BorrowThread("customer5");
                    BorrowThread custome6 = new BorrowThread("customer6");
                    BorrowThread custome7 = new BorrowThread("customer7");
                    BorrowThread custome8 = new BorrowThread("customer8");
                    BorrowThread custome9 = new BorrowThread("customer9");
                    BorrowThread custome10 = new BorrowThread("custome10");
                    custome1.start();
                    custome2.start();
                    custome3.start();
                    custome4.start();
                    custome5.start();
                    custome6.start();
                    custome7.start();
                    custome8.start();
                    custome9.start();
                    custome10.start();
                }
                else {
                    System.out.println("The book is not available since it was never added");
                }
                break;
            case 5:
                viewHistory();
                break;
            default :
                System.out.println("Please enter the correct option...");
        }
    }
}