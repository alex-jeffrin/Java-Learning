# Database Normalization

It is a database design technique that is followed to create a good database
It contains the process of dividing a large amoutn of data into smaller pieces and relating each tables with relationships

## Why need of Normalization 
&emsp; consider this scenario, where we are maintaining a student database that contains student information as well as their department and their repective HOD in the same table as given below.

  Student Id | Student Name | Department | HOD | Contact No |
  --- | --- | --- | --- |--- 
  1 | Suresh | CS | Murali | 0462 882566 |
  1 | Muthu | CS | Murali | 0462 882566 |
  1 | Sam | EEE | Kumar | 0462 659866 |
  1 | Santhosh | CS | Murali | 0462 882566 |
  1 | Abdul | EC | Karan | 0462 962566 |

  ### What could possibly go wrong in the above table?
&emsp;We can see that there  are three coloumns where the departmant name and the HOD name along with the contact number has been reapeated. and this is called redundancy. It could possibly increase the size of the database as well.There are three main problems that data redundancy causes as mentioned below.
Insertion Anomaly
Deletion Anomaly
Updation Anomaly
  
  





## Types of normalization
1. First Normal Form (1 NF)
2. Second Normal Form (2 NF)
3. Third Normal Form (3 NF)
4. Boyce Codd Normal Form or Fourth Normal Form ( BCNF or 4 NF or 3.5)
5. Fifth Normal Form (5 NF)
6. Sixth Normal Form (6 NF)

### 1.First  Normal Form (1 NF)
&emsp; fdjshfjdksh
