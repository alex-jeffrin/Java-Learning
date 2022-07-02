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
4. Boyce Codd Normal Form or Fourth Normal Form ( BCNF or 4 NF or 3.5)
5. Fifth Normal Form (5 NF)
6. Sixth Normal Form (6 NF)

### 1.First  Normal Form (1 NF)
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
 

# Updating ...
