package Utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;


public class Utils {
    public static List<String> booksList  = new LinkedList<>() ;
    public static HashSet<String> uniqueBooksList = new HashSet<String>();
    public static List<String> history = new LinkedList<>();
    public static TreeMap<String,Integer> booksAndQunatity = new TreeMap<String, Integer>();
    public static String bookInput = new String();
    public static List<String> books = new ArrayList<>();
    public static String neededBook;

    public static void loadLibrary(){
        String line ="";
        try{

            Scanner sc = new Scanner(new File("C:\\Users\\Jeffree\\Desktop\\Currency\\CurrencyCovertor\\library\\LibraryBooks.csv"));
            sc.useDelimiter(",");
            while (sc.hasNext()){
                System.out.println();
                booksList.add(String.valueOf(sc.next()));
            }

            for (String c : booksList){
                uniqueBooksList.add(c);
            }
            for (String x : uniqueBooksList){
                booksAndQunatity.put(x, Collections.frequency(booksList, x));
            }
            System.out.println("Library books loaded from csv");
			Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy\thh:mm");
            String strDate= formatter.format(date);
			history.add(strDate + "\t-\tLibrary books loaded from csv");
        }
        catch (Exception e){
            System.out.println("Unable to load the library books from csv");
            System.out.println(e);
        }
    }
	
	
	public static void insertBooks(){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter book names : ");
        bookInput = sc.nextLine();
        books = Arrays.asList(bookInput.split(","));
        for (String x : books){
            booksList.add(x);
        }
        if (!bookInput.isEmpty()){
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy\thh:mm");
            String strDate= formatter.format(date);
            history.add(strDate+"\t-\tBooks added : "+books);
        }
        getBooksQUantity();
    }


    public static void showBooks(){
        System.out.println(booksAndQunatity);
    }
	
	
	public static void searchBook(){
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
    }    
	
	
	static synchronized public Boolean borrowmethod(String name){
        if (booksAndQunatity.get(neededBook) >0){
            booksAndQunatity.put(neededBook, (booksAndQunatity.get(neededBook))-1);
            System.out.println("A copy of "+ neededBook +" Has been borrowed by " +name );
			Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy\thh:mm");
            String strDate= formatter.format(date);
			history.add(strDate + "\t-\tA copy of "+ neededBook +" Has been borrowed by " +name );			
            return true;
        }
        else {
            return false;
        }
    }
    synchronized public static void returnmethod(String name) throws InterruptedException {
		Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy\thh:mm");
        String strDate= formatter.format(date);
		history.add(strDate + "\t-\tA copy of "+ neededBook +" Has been borrowed by " +name );
        Utils.booksAndQunatity.put(Utils.neededBook,(Utils.booksAndQunatity.get(Utils.neededBook))+1);
        System.out.println("A copy of "+neededBook+" has been returned by" + name);

    }
	
	
    public static void viewHistory(){
        if (history.isEmpty()){
            System.out.println("No history available right now...");
        }
        else {
            for (String x : history){
                System.out.println(x);
            }
        }
        System.out.println();
    }
	
	
	public static void getBooksQUantity(){
        for (String x :books)
            if (!uniqueBooksList.contains(x)){
                uniqueBooksList.add(x);
                booksAndQunatity.put((String) x,1);
            }
            else {
                booksAndQunatity.put(x, (booksAndQunatity.get(x))+1);
            }
    }
	
	
	public static void userOption (int option){
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