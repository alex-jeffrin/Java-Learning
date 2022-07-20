package Utilities;

import java.util.Scanner;
import java.util.Date;


interface bookDetailsInterface{
    public void getBookName();
    public void getYearOfPublish();
    public void getCopies();
    public void getAuthor();
    public void getCountry();
}


public class BookDetails implements bookDetailsInterface{

    public String bookName;
    public int yearOfPublish;
    public int copies = 0 ;
    public String authorName;
    public String country;

    public void getBookDetails(){
        getBookName();
        getYearOfPublish();
        getCopies();
        getAuthor();
        getCountry();
    }

    public void getBookName(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter book name\t: ");
        bookName = sc.nextLine();
        if (bookName.isEmpty()){
            getBookName();
        }

    }


    public void getYearOfPublish(){
        Scanner sc = new Scanner(System.in);
        try{
            System.out.print("Enter year of publish \t: ");
            yearOfPublish = sc.nextInt();
            Date d = new Date();
            int currentYear = d.getYear()+1900;
            if (yearOfPublish>currentYear){
                System.out.println("Please enter a valid year...");
                getYearOfPublish();
            }
        }
        catch(Exception e){
            System.out.println("Please enter year in numbers..");
            getYearOfPublish();
        }
    }


    public void getCopies(){
        Scanner sc = new Scanner(System.in);
        try{
            System.out.print("Enter number of copies \t: ");
            copies = sc.nextInt();
            if (copies == 0){
                System.out.println("please enter the number of Copies : ");
                getCopies();
            }
        }
        catch(Exception e){
            System.out.println("Pleas enter an number..");
            getCopies();
        }
    }


    public void getAuthor(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Author\'s  name\t: ");
        authorName = sc.nextLine();
        if (authorName.isEmpty()){
            getAuthor();
        }

    }

    public void getCountry(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Author\'s country\t: ");
        country = sc.nextLine();
        if (country.isEmpty()){
            getCountry();
        }

    }


    public void showBookDetail(){
        System.out.println(bookName);
        System.out.println(yearOfPublish);
        System.out.println(copies);
        System.out.println(authorName);
        System.out.println(country);
    }

}