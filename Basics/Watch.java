import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.lang.*;

class dialWatch {
    int a = 3;
    Date d = new Date();
    long t = d.getTime();
    public void viewDialWatch (){

        System.out.println("Time righ-now\t : "+new SimpleDateFormat("hh:mm:ss:SSS").format(new Date(t)));
        System.out.println("Today\'s date\t : "+d.getDate()+"."+d.getMonth()+"."+d.getYear());

    }
}

class smartWatch extends dialWatch{
    public void viewSmartWatch(){
        int steps = 344;
        viewDialWatch();
        System.out.println("Climate right-not\t:"+"Cool");
        System.out.println("Steps Walked\t:"+steps);

    }

}

public class Watch {
    public static void main (String args[]){
        smartWatch b = new smartWatch();

        System.out.println("Dial-watch face :");
        b.viewDialWatch();
        System.out.println();

        System.out.println("Smart-watch face :");
        b.viewSmartWatch();
        System.out.println();

    }
}
