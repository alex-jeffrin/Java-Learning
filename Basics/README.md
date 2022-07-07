# Java Classes and methods
## Table of contents:
[1. classes](https://github.com/alex-jeffrin/INCUBATION_PROCESS/tree/master/Basics#updating)

[2. General form of class]()

[3. Declaring objects]()

[4. Methods]()

[5. Method inside a class]()

[6. returning value]()

[7. Method with parameter]()

[8. Constructors]()

[9. Parameterized constructors]()

[10. The this keyword]()

[11. Overloading method]()

[12. Overloading constructors]()

[13. Objects as parameters]()

[ Garbage collection]()

[ Finalize method]()
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
















> **UPDATING...**

 
  