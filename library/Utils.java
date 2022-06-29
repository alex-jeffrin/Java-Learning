import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

class Utils {
    static List<String> booksList  = new LinkedList<>() ;
    static HashSet<String> uniqueBooksList = new HashSet<String>();
    static List<String> history = new LinkedList<>();
    static TreeMap<String,Integer> booksAndQunatity = new TreeMap<String, Integer>();
    static String bookInput = new String();
    static List<String> books = new ArrayList<>();

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
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm");
            String strDate= formatter.format(date);
            history.add(strDate+" Books added : "+books);
        }
        getBooksQUantity();
    }


    public static void getBooksQUantity(){
        for (String x :books)
            if (!uniqueBooksList.contains(x)){
                uniqueBooksList.add(x);
                booksAndQunatity.put((String) bookInput,Collections.frequency(booksList,x));
            }
            else {
                booksAndQunatity.put(x, (booksAndQunatity.get(x))+Collections.frequency(books,x));
            }
    }

    public static void showBooks(){
        System.out.println(booksAndQunatity);
    }

    public static void borrowBook(){
        System.out.println(uniqueBooksList);
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the book you want to borrow : ");
        try{
            String neededBook =  sc.nextLine();
            if (booksAndQunatity.get(neededBook) != 0 ){
                System.out.println("Borrowed 1 book: "+neededBook);
                System.out.println();
                booksAndQunatity.put(neededBook, (booksAndQunatity.get(neededBook))-1);
                Date date = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm");
                String strDate= formatter.format(date);
                history.add(strDate+" Books borrowed : "+neededBook);
            } else if (uniqueBooksList.contains(neededBook)) {
                System.out.println("Book is out of Stock");
                System.out.println();
            }

        }catch (Exception e){
            System.out.println("Not found since this book is not added");
            System.out.println();
        }

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


    public static void loadLibrary(){
        String line ="";
        try{

            Scanner sc = new Scanner(new File("C:\\Users\\Jeffree\\IdeaProjects\\SortedBooks\\src\\LibraryBooks.csv"));
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
        }
        catch (Exception e){
            System.out.println("Unable to load the library books from csv");
            System.out.println(e);
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