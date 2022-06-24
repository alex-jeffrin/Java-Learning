abstract class Cat {

    public void type (){
        System.out.println("This is a cat type..");
    }
    public abstract void eatMethod();   //It says this method is mandototy but it does not have a default thing
                                        //The subclasses must have this method or else it will be considered as
                                        //compile time error
}

class Cheetah extends Cat{

    public void family(){
        System.out.println("this is a cheetah family");
    }
    public void eatMethod(){
        System.out.println("The methodology of cheetah eating is by hunting");
    }

}

public class AbstractMethod {
    public static void main (String args[]){
        Cheetah a = new Cheetah() ;
        a.type();
        a.family();
        a.eatMethod();

    }
}
