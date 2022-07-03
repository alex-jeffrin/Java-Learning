# Database Normalization

It is a database design technique that is followed to create a good database
It contains the process of dividing a large amoutn of data into smaller pieces and relating each tables with relationships

## Why need of Normalization 
&emsp; consider this scenario, where we are maintaining a student database that contains student information as well as their department and their repective HOD in the same table as given below.

  Student Id | Student Name | Department | HOD | Contact No |
  --- | --- | --- | --- |--- 
  1 | Suresh | CS | Murali | 0462 882566 |
  2 | Muthu | CS | Murali | 0462 882566 |
  3 | Sam | CS | Murali | 0462 882566 |
  4 | Santhosh | CS | Murali | 0462 882566 |
  5 | Abdul | CS | Murali | 0462 882566 |

  ### What could possibly go wrong in the above table?
&emsp;We can see that there  are three coloumns where the departmant name and the HOD name along with the contact number has been reapeated. and this is called redundancy. It could possibly increase the size of the database as well.There are three main problems that data redundancy causes as mentioned below.

### 1. Insertion Anomaly
&emsp; If we need to add another student to the table we need to add data for the student name and id then rest of the data will be repeated as same in the table. When we want to enter the details for 100 more students of the same department then it will take a lot of space.--
### 2. Deletion Anomaly
&emsp; If we try to delete the students data from the table, along with the student data the data of the HOD is also deleted at the end. and even the students are out of the college and their data has been removed HOD's still remains in the college there will be no data of HOD's. If we notice keenly we can see that unknowingly we have storing two kinds of information in this table. One is the Student data and the another one is the HOD's data.
### 3. Updation Anomaly
If the HOD is out of the department and the system admin needs to update the database. the system admin needs to update the HOD detail to every specific entity of the table. Making it really a worse thing.     
  
  

This is how  Data Redundancy causes issues in database. Not only in the case of storage also in the Insertion, Deletion and Updation of Data



## Types of normalization
1. First Normal Form (1 NF)
2. Second Normal Form (2 NF)
3. Third Normal Form (3 NF)
4. Boyce Codd Normal ( BCNF or 3.5)
5. Fifth Normal Form (5 NF)
6. Sixth Normal Form (6 NF)

  ## 1.First  Normal Form (1 NF)
&emsp; If a value in a table or relation contains multivalued or composite values as its attributes. then it violates the first normal form. For example consider the table below.

  Student Id | Student Name | Contact No | Favourite Sports |
  --- | --- | --- |--- 
  1 | Suresh | 7894561233 | Cricket, Tennis |
  2 | Muthu | 9874561233 | Kabadi |
  3 | Sam | 6123547899 | Cricket, Football |

&emsp; In the above table we can see that the values in the favourite sports coloumns have some composite values in their columns like the student Suresh like more than one sports namely Cricket and Tennis which are mentioned as same values. This violates the first normal form  so we can convert the above example as shown below to follow the first normal form.


  Student Id | Student Name | Contact No | Favourite Sports |
  --- | --- | --- |--- 
  1 | Suresh | 7894561233 | Cricket |
  1 | Suresh | 7894561233 | Tennis |
  2 | Muthu | 9874561233 | Kabadi |
  3 | Sam | 6123547899 | Cricket |
  3 | Sam | 6123547899 | Football |

  &emsp; You may think that it may cause data redundancy but the main dact of following data normalization is to minimalize data redundancy. if we need to update contact no for any student still its possible cause, we can make it by using the student id as the primary key.

  ## 2.Second  Normal Form (2 NF)
 ## Rules :
 * It is mandatory for the database to be in first Normal form.
 * There must not be any partial dependency in a table 

 ## What is a partial Dependency?

 Lets consider the following example for the partial dependancy.

 Student Id | Score Id | Subject ID | Marks | Subject Teacher |
  --- | --- | --- |--- |--- 
  1 | 1 | 1 | 85 | Gurunath
  1 | 2 | 2 | 83 | Santhosh 
  3 | 3 | 1 | 96 | Gurunath
  4 | 4 | 1 | 81 |Gurunath
  4 | 5 | 2 | 79 |Santhosh

&emsp; In the above table we are able to see that if we need a mark of a student for a specific subject, We need bot the subject Sd and the Student Id. Cause, if we only have the Student Id we are not able to get the marks for specific subject. If we have the Subject Id alone then we will not be able to identify the mark for the specific student. so the primary key for this table would be Student Id + Subject Id. Which gives the mark of a student for a specific subject.but here we have the Subject Teacher name also but it only depends on the subject id alone and it cannot be used as a determinant also. so it partialy depends on the primary key. 

## How can we make the table follow Second Noraml Form ?
&emsp; in order to be in second normal form there must not be any partial dependency in a table. so we can make the table as below to make it in a second normal form.

Student Id | Score Id | Subject ID | Marks 
  --- | --- | --- |---  
  1 | 1 | 1 | 85 
  1 | 2 | 2 | 83  
  3 | 3 | 1 | 96 
  4 | 4 | 1 | 81 
  4 | 5 | 2 | 79 

 Subject Id | Subject Teacher
--- | --- |
1 |Gurunath
2 |Santhosh

Now we have seperated the subject teacher details into a seperate table now there will not be any partial dependency in the student score table. Now the table is in second Normal Form. 

  ## 3.Third  Normal Form (3 NF)
 ## Rules :
 * It is mandatory for the database to be in Second Normal form.
 * There must not be any Transitive dependency in a table 

 ## What is a Transitive Dependency?
 Lets take the above score table as example but this time lets add two coloumns as exam name and total marks in it.

 Student Id | Score Id | Subject ID | Marks | Exam name | Total marks
  --- | --- | --- |--- |--- |---  
 --- | --- | --- |--- |--- |---
  --- | --- | --- |--- |--- |---

  so now in the above table lets say there might be different exams for student if there is a computer student he\ she will have a computer related exams, If he\she is a micro biology student then they will have a different exams. a computer science student may have practical examination which has a total marks of 30 and Theory examination which has a total marks as 70 so it depends on the exam name. so in our table the total marks doesnt depends on the student name or Student Id or subject id. It depends on the exam name. but exam name is not a part of primary key cause in this table primary key is a composite key which is identified by the Student id + Subject Id. But the total marks is dependent on the exam name which is not a part of the primary key this is known as Transitive Dependency.

  ## How Transitive Dependency is different from partial Dependency?

  In partial dependency the Subject id uniquely identifies the Subject teacher which is a part of primary key. But here in Transitive Dependency the Total marks attribute is dependent on the exam name which is not a part of primary key. This is the difference bettwen the Partical Dependency and Transitice Dependency.

## How can we make the table follow Third Noraml Form ?

 Student Id | Score Id | Subject ID | Marks | Exam name 
  --- | --- | --- |--- |---  
 --- | --- | --- |--- |--- 
  --- | --- | --- |--- |--- 

  Exam name | Total marks
  --- | --- |
  --- | --- |
  --- | --- |
  
  &emsp; Now the exam name field and the total marks field has been seperated from the main table. no the table is in third noraml form.


## 4 Boyce Codd Normal Form ( BCNF or 3.5NF)

## Rules :
* It is mandatory for the database to be in Second Normal form.
* There must not be any Reverse dependency in a table 

## What is Reverse Dependency?
Lets take the beow table as example


Student Name | Subject | Subject Staff |
--- | ---| ---
  Sam | Python | Venkatesh 
  Santhosh | Python | Muthu 
  Sam | C++ | Selvam 
  Raja | python | Venkatesh 
  Santosh | JAVA | Shankar 

&emsp; In the above table we are able to see that the the there can be different teachers for the same subject, but a teacher can handle only one subject. so in the above table Student name + Subject act as a candidate key which will determines the staffs who handles the subject. In other terms we can also take Student name + Staff to determine the subject, this 
here sunject staff is not a prime attribute but it is a determinent which detemines the subject. here we think that a partial dependency occurs But, no. Cause in partial dependency the attribute that is detemined by the partial key attribute cannot be reversed to find that partial key attribute. But here it can be used as a determinant also to find the determinant.It is called as Reverse Dependency. In order to break this we need to seperate the table as below.

  Student name | SUbject
  --- | --- |
  Sam | Python |
  Santhosh | Python |
  Sam | C++ |
  Raja | python |
  Santosh | JAVA |

  Subject | Subject staff
  --- | --- |
  Python | Venkatesh 
  Python | Muthu 
  Sam | C++ | Selvam 
  JAVA | Shankar

## 5 Fourth Normal Form (4NF)

## Rules :
* It is mandatory for the database to be in BCNF Normal form.
* There must not be any Multi-value dependency in a table 

## Conditions for Multi-Valued Dependency :

- A table must have atleast 3 coloumns.
  - For Example : A-Coloumn, B-Coloumn, C-Coloumn.
- For a  Single value of A-coloumn multiple values in B-coloumn exists.
  - For example : an Student id in a table can show mobile number of an Student, Single Student will have multiple mobile numbers.
- For a relation between Two coloumns A-Coloumn -> B-Coloumn it does not determines C-Coloumn same vice versa for relation A-Coloumn -> C-Coloumn

&emsp; Lets consider the below table as example.

Student Id | Favourite Subject | Hobby |
--- | ---| ---
  1 | Python | Gaming 
  1 | C++ | Cycling 
  2 | Python | Gaming 
  2 | JAVA | Music 
  3 | python | Cycling 

  &emsp; So the above table satisfy the first condition of multivalued dependency by having three coloumns.
  By using student id we can get multiple favourite subject as well as multiple hobbies. and so it satifies the second condition. hobby attribute and the facourite subject attribute does not have any relation between then hence the 3rd condition also satified. The table have multi valued dependency.

  ## What coud go wrong?

&emsp; If we try to take the Student id as 1 and favourite language as python we can get the hobby as gaming. But, there is one more hobby for the student id 1. If we need the second hobby we need to use the another favourite subject. or if we need to get the two hobbies we need to duplicate the student id and faourite subject number of times the hobby exist which consumes lot of space instead we can split this table into two as below to avoid Multi-valued dependency.

Student Id | Favourite Subject 
--- | ---
  1 | Python 
  1 | C++ 
  2 | Python 
  2 | JAVA 
  3 | python 

  Student Id | Hobby |
--- | ---
  1 | Gaming 
  1 | Cycling 
  2 | Gaming 
  2 | Music 
  3 | Cycling 


## 6 Fifth Normal Form (5NF)

## Rules :
* It is mandatory for the database to be in Fourth Normal form.
* There must not be join dependency in a table and lossless decomposition must occur while natural joining of tables that we have splitted.

## What is Decompostition?
After the table reaches a limit where the table cannot be splitted more it reaches its limit. After dividing the tables into several tables. The process in which we try to join the table to see the real table is called decompostion.
There are two types of Decompostitons. namely,
- Lossfull Decompostion
  - The time in which data gets lost or added during the process of decompostiton.
- Lossless Decomposition
  - The time in which data does not have any loss or addition of data  during the process of decompostiton.


  If the process of Decomposition made successfull then the table is said to be in Fifth Normal Form (5 NF). 




