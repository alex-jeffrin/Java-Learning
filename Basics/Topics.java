//import java.math.BigDecimal;
//
//public class Day7 {
//    public static void main(String[] args) {
//        BigDecimal n = new BigDecimal("1.22222222222256569823123123121");
//        System.out.println(n);
//    }
//}



//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/* This program demonstrates the difference between
   public and private.
*/
//class Test {
//    int a; // default access
//    public int b; // public access
//    private int c; // private access
//
//    // methods to access c
//    void setc(int i) { // set c's value
//        c = i;
//    }
//    int getc() { // get c's value
//        return c;
//    }
//}
//class Day7 {
//    public static void main(String args[]) {
//        Test ob = new Test();
//
//        // These are OK, a and b may be accessed directly
//        ob.a = 10;
//        ob.b = 20;
//
//        // This is not OK and will cause an error
////  ob.c = 100; // Error!
//
//        // You must access c through its methods
//        ob.setc(100); // OK
//        System.out.println("a, b, and c: " + ob.a + " " +
//                ob.b + " " + ob.getc());
//    }
//}


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


import java.util.Scanner;

class Test{
    int a = 4;
    private int n = 456;

    public int getScore(int marks){
        return n*marks;
    }

    public int getn(){
        return n;
    }
}



//class Day7{
//    public static void main(String[] args) {
//        final int a = 8;
//        int b = a;
//        Scanner sc = new Scanner(System.in);
//
//        try {
//            int c = sc.nextInt();
//        }
//        catch (Exception e){
//            System.out.println("please eneter numberic values alone...");
//        }

//        Test m = new Test();

//        System.out.println(a);
//        System.out.println(m.a);
//        System.out.println(m.getn());
//        System.out.println(m.getScore(a));
//    }
//}





///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////




class Day7{
    public static void main (String args[]){

        int a = 9;
        int i;
        for (i=0; i<args.length;i++){
            System.out.print(args[i]);
        }

	System.out.println(args[8]);
    }
}

