import java.util.*;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

class Utils {
    static List<String> booksList  = new LinkedList<>() ;
    static HashSet<String> uniqueBooksList = new HashSet<String>();
    static List<String> history = new LinkedList<>();

    static TreeMap<String,Integer> countBooks = new TreeMap<String, Integer>();

    static int t = 0;
    static String input = new String();

    public static void insertBooks(){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter book names : ");
        input = sc.nextLine();
        List<String> books = Arrays.asList(input.split(","));
        Collections.sort(books);
        for (String x : books){
            booksList.add(x);
        }
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        String strDate= formatter.format(date);
        history.add(strDate+" Books added : "+books);
        createUniqueList();
        setCountBooks();
    }

    public static void createUniqueList(){
        uniqueBooksList.clear();
        for (String c : booksList){
            uniqueBooksList.add(c);

        }


    }
    public static void setCountBooks(){
        if (t==0) {
            for (String x : uniqueBooksList)
                countBooks.put(x, Collections.frequency(booksList, x));
        }
        else if (!uniqueBooksList.contains(input)){
            booksList.add(input);
            createUniqueList();
            countBooks.put((String) input,1);

        }
    }

    public static void showBooks(){
        System.out.println(countBooks);
    }

    public static void borrowBook(){
        System.out.println(uniqueBooksList);
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the book you want to borrow : ");
        try{
            String neededBook =  sc.nextLine();
            if (countBooks.get(neededBook) != 0 ){
                System.out.println("Borrowed 1 book: "+neededBook);
                System.out.println();
                countBooks.put(neededBook, (countBooks.get(neededBook))-1);
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
        for (String x : history){
            System.out.println(x);
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
            createUniqueList();
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