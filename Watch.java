import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.lang.*;

class dialWatch {
    int a = 3;
    Date d = new Date();
    long t = d.getTime();
    public void viewDialWatch (){

        System.out.println("Dial-watch face :");
        System.out.println("Time righ-now\t : "+new SimpleDateFormat("hh:mm:ss:SSS").format(new Date(t)));
        System.out.println("Today\'s date\t : "+d.getDate()+"."+d.getMonth()+"."+d.getYear());

    }
}

class smartWatch extends dialWatch{
    public void viewSmartWatch(){
        int steps = 344;
        System.out.println("Smart-watch face :");
        System.out.println("Time righ-now\t : "+new SimpleDateFormat("hh:mm:ss:SSS").format(new Date(t)));
        System.out.println("Today\'s date\t : "+d.getDate()+"."+d.getMonth()+"."+d.getYear());
        System.out.println("Climate right-not\t:"+"Cool");
        System.out.println("Steps Walked\t:"+steps);

    }

}

public class Watch {
    public static void main (String args[]){
        dialWatch a = new dialWatch();
        smartWatch b = new smartWatch();

        a.viewDialWatch();
        System.out.println();

        b.viewSmartWatch();
        System.out.println();

    }
}
