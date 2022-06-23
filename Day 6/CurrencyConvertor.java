import java.io.CharArrayReader;
import java.util.Scanner;

public class CurrencyConvertor {

    static double
            UE = 0.95, UC = 1.30, UI = 78.11, EU = 1.05, EC = 1.36, EI = 82.17,
            CU = 0.77, CE = 0.73, CI = 60.30, IU = 0.013, IE = 0.012, IC = 0.017;
    public static void currencyConversion(int option, double currency) {
        
        switch (option){
			case 1:
                System.out.println("USD to INR : " + Math.round(currency*UI*100)/100.0);
                System.out.println("USD to CAD : " + Math.round(currency*UC*100)/100.0);
                System.out.println("USD to EUR : " + Math.round(currency*UE*100)/100.0);
                break;

            case 2:
                System.out.println("EUR to USD : "+ Math.round(currency*EU*100.0)/100.0);
                System.out.println("EUR to INR : "+ Math.round(currency*EI*100.0)/100.0);
                System.out.println("EUR to CAD : "+ Math.round(currency*EC*100.0)/100.0);
                break;

            case 3 :
                System.out.println("CAD to USD : "+Math.round(currency*CU*100.0)/100.0);
                System.out.println("CAD to INR : "+Math.round(currency*CI*100.0)/100.0);
                System.out.println("CAD to EUR : "+Math.round(currency*CE*100.0)/100.0);
                break;

            case 4:
                System.out.println("INR to USD : " + Math.round(currency*IU*100.0)/100.0);
                System.out.println("INR to EUR : " + Math.round(currency*IE*100.0)/100.0);
                System.out.println("INR to CAD : " + Math.round(currency*IC*100.0)/100.0);
                break;

        }
		System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("Currency conversion application...");
        Scanner sc = new Scanner(System.in);
        int option = 1;
		do{
			System.out.println("Select and option :\n1. U.S. Dollar (USD)\n" +
                "2. European Euro (EUR)\n" +
                "3. Canadian Dollar (CAD)\n" +
                "4. Indian Rupees (INR)\n"+
                "0. Exit\n");
			System.out.print("Enter your option : ");
			option = sc.nextInt();
			if (option ==0){
				break ;
			}
            System.out.print("Please enter the currencies in numbers : ");
            double currency = sc.nextDouble();
            currencyConversion(option,currency);
		}
       
        while (option!= 0);        
        
        System.out.println("Application Stopped");


    }

}
