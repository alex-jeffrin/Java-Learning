package Utilities;

import Utilities.BookDetails;
import com.google.gson.Gson;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.io.IOException;
import java.net.URL;
import java.net.HttpURLConnection;

class History {
    String time;
    String event;
    String action;

    History(String time, String event, String action) {
        this.time = time;
        this.event = event;
        this.action = action;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getEvent() {
        return this.event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getAction() {
        return this.action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}


class HistoryDetails{
    List<History> list;

    public HistoryDetails() {
        this.list = new ArrayList<>();
    }

    public HistoryDetails(java.util.List<History> list) {
        this.list = list;
    }

    public java.util.List<History> getList() {
        return list;
    }

    public void setList(java.util.List<History> list) {
        this.list = list;
    }
}


public class Utils {
    static List<String> booksList  = new LinkedList<>() ;
    static HashSet<String> uniqueBooksList = new HashSet<String>();
    static TreeMap<String,Integer> booksAndQunatity = new TreeMap<String, Integer>();
    static TreeMap<String,String> authorDetails = new TreeMap<String, String>();
    static String bookInput = new String();
    static List<String> books = new ArrayList<>();
    static String neededBook;
    static int copies ;
    static int yearOfPublish ;
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
        } catch (Exception e) {
        }
    }


    public static void loadDB(){

        ResultSet queryResult = null;
        try {
            String loadQuery = "SELECT * FROM public.library_db";
            queryResult = statement.executeQuery(loadQuery);
            int booksloaded = 0;
            while (queryResult.next()){
                int i =queryResult.getInt("book_quantity");
                booksAndQunatity.put(queryResult.getString("book_name"),i );
                uniqueBooksList.add(queryResult.getString("book_name"));
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


    public static void insertBooks(){
        BookDetails book = new BookDetails();
        book.getBookDetails();
        book.showBookDetail();
        booksList.add(book.bookName);
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy\thh:mm");
        String strDate= formatter.format(date);
        try{

            String sqlQuery = "INSERT INTO public.library_history(event_time, event, action) VALUES ('"+strDate+ "','book added : "+book.bookName+"','Insert')";
            statement.executeUpdate(sqlQuery);
            System.out.println(book.yearOfPublish);
            System.out.println(book.bookName);
            System.out.println(book.yearOfPublish);
        }
        catch(Exception e){
            System.out.println("unable to add history...");
        }
        if (uniqueBooksList.isEmpty()){
            try {

                String sqlQuery = "INSERT INTO public.library_db (book_name,book_quantity,year) VALUES ('"+book.bookName+"',"+book.copies+","+book.yearOfPublish+")";
                System.out.println(sqlQuery);
                int rows = statement.executeUpdate(sqlQuery);
                if (rows>0){
                    System.out.println("book has been added...");
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        if (!uniqueBooksList.contains(book.bookName)){
            try {
                String sqlQuery = "INSERT INTO public.library_db (book_name,book_quantity,year) VALUES ('"+book.bookName+"',"+book.copies+","+book.yearOfPublish+")";
                int rows = statement.executeUpdate(sqlQuery);
                if (rows>0){
                    System.out.println("book has been added...");
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
            uniqueBooksList.add(book.bookName);
            booksAndQunatity.put((String) book.bookName,book.copies);
        }
        else {
            booksAndQunatity.put(book.bookName, (booksAndQunatity.get(book.bookName))+book.copies);
            try{
                String sqlQuery = "UPDATE public.library_db SET book_quantity="+(booksAndQunatity.get(book.bookName))+" WHERE book_name='"+book.bookName+"';";
                int rows = statement.executeUpdate(sqlQuery);
                if (rows>0){
                    System.out.println("book has been added...");
                }
            }
            catch (SQLException e) {
                System.out.println(e);
            }
        }

    }


    public static void showBooks() throws SQLException {
        if (!booksAndQunatity.isEmpty()){
            System.out.println(booksAndQunatity);
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy\thh:mm");
            String strDate= formatter.format(date);
            String sqlQuery = "INSERT INTO public.library_history(event_time, event, action) VALUES ('"+strDate+ "','Books viewed','View')";
            statement.executeUpdate(sqlQuery);
        }
        else{
            System.out.println("No books available right now...");
        }
    }


    public static void searchBook() throws SQLException {
        int count =0 ;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter keywords to search : ");
        String keywords = sc.nextLine();
        if(keywords.isEmpty()){
            System.out.println("Please enter keyword to find a match...");
            searchBook();
        }
        System.out.println();
        System.out.println("Books matched :");

        for (String names : uniqueBooksList)

            if((names.toLowerCase()).contains(keywords.toLowerCase())){
                count++;
                System.out.println(count+". "+names);
            }
        if (count>0){
            System.out.println("Total number of books matched: "+count);
        }

        if(count ==0){
            System.out.println("None.");
        }
        System.out.println();
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy\thh:mm");
        String strDate= formatter.format(date);
        String sqlQuery = "INSERT INTO public.library_history(event_time, event, action) VALUES ('"+strDate+ "','Searched for book : "+keywords+"','Search')";
        statement.executeUpdate(sqlQuery);
    }


    public static void viewHistory() throws IOException {
        URL obj = new URL("http://localhost:8080/LibraryHistory/api/history/showhistory");
        HttpURLConnection con = (HttpURLConnection)obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        con.setRequestProperty("Accept", "application/json");
        System.out.println(con.getInputStream());

        
        String json_str = getResponse(con.getInputStream());
        Gson gson = new Gson();
        HistoryDetails details = gson.fromJson(json_str,HistoryDetails.class);


        System.out.println("Time :\t\t\t\tAction :\tEvent :");
        for (History history:details.getList()){
            System.out.println(history.getTime()+"\t"+history.getAction()+"\t\t"+history.getEvent());
        }
    }

    static String getResponse(InputStream stream) throws IOException {
        StringBuffer buffer = new StringBuffer();
        int data = stream.read();
        while (data != -1){
            buffer.append((char) data);
            data = stream.read();
        }
        return buffer.toString();
    }
//    public static void viewHistory() throws SQLException {
//        Date date = new Date();
//        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy\thh:mm");
//        String strDate= formatter.format(date);
//        String sqlQuery = "INSERT INTO public.library_history(event_time, event, action) VALUES ('"+strDate+ "','Viewed history ','View')";
//        statement.executeUpdate(sqlQuery);
//        sqlQuery = "SELECT * FROM public.library_history";
//        ResultSet queryResult = null;
//        queryResult = statement.executeQuery(sqlQuery);
//        while(queryResult.next()){
//            System.out.print(queryResult.getString(1));
//            System.out.print("\t"+queryResult.getString(2));
//            System.out.print("\t("+queryResult.getString(3)+")");
//            System.out.println();
//        }
//        System.out.println();
//    }




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


    public static void showAuthors(){

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
                try{
                    viewHistory();
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                break;
            case 6:
                booksAndQunatity.clear();
                loadDB();
                System.out.println("The database has been reloaded...");
                break;

            case 7:
                showAuthors();
                break;
            default :
                System.out.println("Please enter the correct option...");
        }
    }
}