# Java Classes and methods
## Table of contents:
[1. classes](https://github.com/alex-jeffrin/INCUBATION_PROCESS/tree/master/Basics#updating)

[2. General form of class](https://github.com/alex-jeffrin/INCUBATION_PROCESS/tree/master/Basics#2-general-form-of-class-)

[3. Declaring objects](https://github.com/alex-jeffrin/INCUBATION_PROCESS/tree/master/Basics#3-declaring-objects)

[4. Methods](https://github.com/alex-jeffrin/INCUBATION_PROCESS/tree/master/Basics#4-methods)

[5. Method inside a class](https://github.com/alex-jeffrin/INCUBATION_PROCESS/tree/master/Basics#5-methods-inside-a-class)

[6. returning value](https://github.com/alex-jeffrin/INCUBATION_PROCESS/tree/master/Basics#6returning-value)

[7. Method with parameter](https://github.com/alex-jeffrin/INCUBATION_PROCESS/tree/master/Basics#7-methods-with-parameter)

[8. Constructors](https://github.com/alex-jeffrin/INCUBATION_PROCESS/tree/master/Basics#8-constructors)

[9. Parameterized constructors](https://github.com/alex-jeffrin/INCUBATION_PROCESS/tree/master/Basics#9-parameterized-constructors)

[10. The this keyword](https://github.com/alex-jeffrin/INCUBATION_PROCESS/tree/master/Basics#10-the-this-keyword)

[11. Overloading method](https://github.com/alex-jeffrin/INCUBATION_PROCESS/tree/master/Basics#11-method-overloading)

[12. Overloading constructors](https://github.com/alex-jeffrin/INCUBATION_PROCESS/tree/master/Basics#12-constructor-overloading)

[13. Objects as parameters](https://github.com/alex-jeffrin/INCUBATION_PROCESS/tree/master/Basics#13-objects-as-parameters)

[14. Garbage collection](https://github.com/alex-jeffrin/INCUBATION_PROCESS/tree/master/Basics#14-garbage-collection)

[15. Finalize method](https://github.com/alex-jeffrin/INCUBATION_PROCESS/tree/master/Basics#15-finalize-method)
## 1. classes 
  classes in other words are used defined data types. it also has its own default constructor.those constructors can also me overriden. class has varible declared it will be called as instance varable when an object is created.

## 2. General form of class :
 classes have the following syntax to declare 

 ```java 
 Classname objectname = new classname();
 ```
 it can also be written as 

```java 
 Classname objectname ;
 objectname = new Classname();
```
first it create a reference of class as a type and initially it will be null. and while executing the second statement it creates a dynamic memory in heap memory and the address of the memory is stored in that variable.


The structure of the class will be as follow 

```java
class classname {
  datatype instance-variable1 ;
  datatype instance-variable2 ;

  type method(){
    //Statement to execute
  }

  access_specifier type method(parameter){
    //Statement to execute
  }
}
```

## 3. Declaring objects 


Declaring of objects are as follow

 ```java 
 Classname objectname = new classname();
 ```

 we can also reference an object to a new variable as like below

 
 ```java 
 Classname objectname1 = new classname();

 Classname objectname2 = objectname1;


 ```

 ## 4. Methods

 the methods are functions that are declared inside the class. the methods inside the class can be used after creating an object for the class. The general form of a method is as show below 

 ```java 
 access_modifier return_type method_name(type parameters){

  //statements to be executed
  //body of method
  return value;
 }
```


## 5. Methods inside a class 
a method inside a class can be accesed after the object is created for the class. after creation of the object those methods can be accessed using the dot (.) Operator as shown below.

```java
class classname {
  access_modifier return_type method_name(type parameters){

  //statements to be executed
  //body of method
  return value;
 }
}

class MethodExample{
  public static void main (String args[]){
    classname obj1 = new classname();   //creating an object for the class

    type variable = obj1.methodname();  //now this line calls the method and assign the returned value to the variable 

  }
}

```

## 6.Returning value
In the ablove topic in the methodswe would have used a word called return value. the return value is a value that is reurned at the end of executing a statement from a metdhod to assign to other. so in the same example given above


```java
class classname {
  access_modifier return_type method_name(type parameters){

  //statements to be executed
  //body of method
  return value;
 }
}

class MethodExample{
  public static void main (String args[]){
    classname obj1 = new classname();   //creating an object for the class

    type variable = obj1.methodname();  //now this line calls the method and assign the returned value to the variable 

  }
}

```

we are able to see that we create an object and we assign the return value from the method to a new variable. which actually brings a returned value from the method that has been called.

## 7. Methods with parameter
The methods may have parameter, which are like boundries we need to give values without exceeding the boundries. for example if we declare a method that does addition of two values. we need to give a parameter with two variables. those 2 variables that are passed are called arguments.

we need to declare the type we are going to pass as argument. The argument passed must match the datatype that has been defined in the parameter. lets se a sumple addition of two numbers program

```java
class AddTwo{

    public int additionMethod(int m,int n){ //parameter with two variables of int datatype...

        return m+ n;
        
    }
}

class AdditionOfTwo{
    
    public static void main (String args[]){
        
        int a = 6;
        int b = 4;
        AddTwo obj1 = new AddTwo();

        int c= obj1.additionMethod(a,b);
        System.out.println(c);
        
    }
}
```

In the above program a varable c assigned to the methods return value. Initially it looks throught the method that has been called inside the object. Two values have been passed as argument which will enter the method and after entering, The method return the summation of two numbers as return value. the value returned will be assigned to the variable c. the output will be as below 

### Output :

```bash 
c:\Users\ExampleProgram> javac AdditionOfTwo.java
c:\Users\ExampleProgram> java AdditionOfTwo

10

Process finished with exit code 0
```
## 8. Constructors
Constuctors are like default methods that will be called whenevere an object is created. those constructors can also be overridden by the user to ask for the variables while creating an object, We can create a class with default values or properties with the constructor. Constructor method will have the same name as the class name. It may have parameters that user need to give when the creation of object, or the default constructor may have some other value to be initialized during the creation of the object. below is the example code for constructor.

```java 
class AddTwo{

    int m ;
    int n;

    AddTwo(){
        int m = 2;
        int n = 3;
    }

    AddTwo(int i, int j){

        int m = i;
        int n = j;

    }

    public int additionMethod(){ //parameter with two variables of int datatype...

        return m+ n;

    }
}

class AdditionOfTwo{

    public static void main (String args[]){

        int a = 6;
        int b = 4;
        AddTwo obj1 = new AddTwo();
        AddTwo obj2 = new AddTwo(a,b);


        int c = obj1.additionMethod();
        int d = obj2.additionMethod();
        
        System.out.println("Object with no parameters : "+ c);
        System.out.println("Object with 2 parameters : "+d);

    }
}
```

In the above example we have created two constructors one with the default values and another one with a parameter which expects two arguments from the user to give. Now there is option either user can give parameter during initialization of object or it can be emplty so that the constructor by default it will  assign the value as m = 1 and n = 6. the output will be as follow 

### Output :
```bash 
c:\Users\ExampleProgram> javac AdditionOfTwo.java
c:\Users\ExampleProgram> java AdditionOfTwo

Object with no parameters : 5
Object with 2 parameters : 10

Process finished with exit code 0
```

## 9. Parameterized constructors
Parameterized constructor example is given above. the constructor ecpects parameters to be passed during the creation of objects
```java
class AddTwo{

    int m ;
    int n;

    AddTwo(int i, int j){

        int m = i;
        int n = j;

    }

    public int additionMethod(){ 

        return m+ n;

    }
}

class AdditionOfTwo{

    public static void main (String args[]){

        int a = 6;
        int b = 4;
        AddTwo obj1 = new AddTwo(a,b);  //parameters passed during creation of objects.


        int c = obj1.additionMethod();
        
        System.out.println("Object with parameters : "+ c);

    }
}
```
The above program expects the user to give two values when the objects are created for the classes as there is no default value constructor it will shows error during the compile time if the user forgets to give the parameter for the objects during the initialization.

## 10. The this keyword
The **this** keyword is  used to refer the current object that has been called. it is majorly used to prevent naming classhed during assigning the local varibale to the instance variable through parameters.
for example take the below program.
```java
class AddTwo{

    int m ;
    int n;

    AddTwo(int i, int j){

        i = i;
        j = j;

    }
}
```
In the above class the class the instance variable is named same as the local variable which is enterd as a parameter now there will be a class for assigning a variable it will be like i = i for the paramter value is assigned to itself instead of assigning to the instance variables. to prevent this we need to use the **this** keyword which will refer the current object. While using the this keyword with a variable it refers the variable of the specific instance sot the above program can be written as below

```java
class AddTwo{

    int m ;
    int n;

    AddTwo(int i, int j){

        this.i = i;
        this.j = j;

    }
}
```
now it takes the value from the parameter and assign the values to the curren objects variable without any clash.

## 11. Method overloading

Method overloading refers to defining methods with the same name multiple times.  to handle differnt scenarios of caliing the methods

A best example is that if we are having a function to add two numbers that takes two arguments as parameter. if the input is of int type there will be a seperate method to handle the int type method, another method will be there for handling the floating type. another type


```java
class AddTwo{

    int m ;
    int n;

    public int additionTwo (int i, int j){
      m = i;
      n = j;
      return m+n;
    
    }

    public int additionTwo (float i, float j){
      m = i;
      n = j;
      return m+n;
    
    }

    public int additionTwo (double i, double j){
      m = i;
      n = j;
      return m+n;
    
    }
    
}
```

This example relates with constructor overloading also, cause the constructor is also a method that is called at the initial stage of creating a object instance for a class.


## 12. Constructor overloading 

Conside the scenario. If an user is trying to create a constructor to initialize the value of instance varibles during the creation of the class objects.

For example if user enters arguments with different data type then these constructor overloading can be used by creating method with the same name but it asks for differnet datatype of parameter for better understanding lets take the below example.

```java
class AddTwo{

    int m ;
    int n;

    AddTwo(int i, int j){

        this.i = i;
        this.j = j;

    }
    AddTwo(float  i, float j){

        this.i = i;
        this.j = j;

    }
    AddTwo(double i, double j){

        this.i = i;
        this.j = j;

    }
    
}
```

So, in the above example the object needs two values as an arguments but event it is os int type or float or double based on the user input it will just select the method that suits the constructor that has been overloaded.


We have created three constructors that overloads the constructor methods. 
this concept of creating constructors with the same name for handling different datatype input from the user also comes under constructor overloading.

## 13. Objects as parameters
We can even pass objects as parameters for the methods that we use inside the classes. for example if we are having an object like box which is having its own dimension as height. width and breadth. we can use that object to assign those values to create a new object of the same class by passing this object as parameter and assigning by accessing the instance variable using the dot operator ( . ). Lets conside the example given below.

```java

class Box {
  int height;
  int width ;
  int breadth;

  Box(int i, int j, int  k) {
    height = i;
    width = j;
    breadth = k;
  }

  Box(Box obj){
    height = obj.height
    width = obj.width
    breadth = obj.breadth
  }

}

```
In the above example we can see that the object is passed as parameter and the instance variables of that object is referenced to the newly instanced object to be instanciated. this is method of passing object as a parameter.


## 14. Garbage collection

In our program we dynamically assign memory for the variables. so in oreder to save memory the garbage collector looks for the unused objects or the objects that are reference to null. It looks for the scope of the variable whether it is going to be used in later scenario else the garbage collector clears that memory.

The garbage collector runs priodically at a inknown point of time. We need not want to worry about that. 

but we can forcefully run the garbage collector by calling the static gc() method within the System class as metioned below.

```java
System.gc();
```
or 
```java
Runtime.getRuntime().gc();
```

There is no gurantee that the garbage collector runs at the specific time. By using the above two methods we request for the garbage collector from the JVM on which the application will be running.


## 15. Finalize method


Finalize is a method in java that is used to perfrom clean-up pocess when the garbage collector is called by the JVM. It is used with the objects while garbage collection. this process takes place before the destruction of an object. and it is invoke just befor the object is destroyed.

this is a default method that has the super class Object class. we need to override this method incase if we want to do any actions that is prior to the garbage collection of that object. the finalize method by default looks like below.

```java
protected void finalize() throws Throwable{

}
```

> **UPDATING...**


 
  