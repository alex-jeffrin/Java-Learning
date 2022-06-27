import java.util.*;
class Details{
    private String name;
    private int salary;
    private int id;
    private String domain;

    Details(String s, int i, int n, String d){
        name  = s;
        salary = i;
        id = n;
        domain = d;
    }

    public String toString(){
        return name +"\n"+salary+"\n"+id+"\n"+domain+"\n";
    }
}

public class UserData {
    public static void main(String[] args) {
        LinkedList <Details> detailList = new LinkedList<Details>();

        detailList.add(new Details("sam" ,15000,13,"software"));

        detailList.add(new Details("sankar",15000,5,"Development"));

        detailList.add(new Details("mari",16,45,"advertisement"));

        detailList.add(new Details("kumar",24,23,"marketing"));


        Details[] delailList;
        for (Details contents : detailList)
            System.out.println(contents+"\n");

        System.out.println();

    }
}
