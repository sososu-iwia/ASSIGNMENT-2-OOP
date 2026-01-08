ASSIGNMENT 2
Yerbolatov Damir 

src/
|---Main.java
|--- model/
|    |---Person.java
|    |---Student.java
|    |--- Teacher.java
|    |--- Institution.java
|    |--- DatabaseConnector.java
|--- service/
|    |--- EducationService.java
|--- dao/
|    |---StudentDAO.java
|    |--- TeacherDAO.java
|---ui/
|---ConsoleReader.java
|--- Menu.java
|--- MenuOption.java


Education Management System is a console Java application.
It is used to manage an educational institution.
The system works with students and teachers.
The application allows the user to:
•add students and teachers
•view all people
•search by name
•filter and sort students by GPA
•store data in memory and in a database

Project Structure:
src/
|--- Main.java
|--- model/
|--- service/
|--- dao/
|--- ui/

Classes Description

Main:
•The main class of the program
•Starts the application
•Creates all main objects

Person (abstract class):
•Base class for all people
•Fields:
•id
•name
•age
•Used as a parent class

Student:
•Extends Person
•Additional fields:
•major
•GPA
•courses
•Represents a student

Teacher:
•Extends Person
•Additional fields:
•department
•salary
•subjects
•Represents a teacher

Institution:
•Stores all people in the system
•Uses List<Person>
•Manages students and teachers

EducationService:
•Contains business logic
•Controls the menu and user actions
•Connects UI, model, and database

DAO Classes:
•StudentDAO
•TeacherDAO
•Used to work with the database
•Hide JDBC logic from other parts of the program

UI Classes:
•ConsoleReader
•Menu
•Used for user input and menu display


Project Criteria Explanation:
This project continues work in the education subject area.
It is focused on managing an educational institution, where students and teachers are the main objects.
The program reflects real-life processes such as registration, searching, and organizing people in an institution.
The project follows the data abstraction principle.
A common abstract class Person is used to represent all people in the system.
Because of this, the program can work with students and teachers in a unified and simple way.
Details of database work are hidden inside DAO classes, so other parts of the program do not depend on database logic.
All data in the program is organized in one main data pool.
This data pool is implemented as a list of people inside the Institution class.
The institution manages this list and controls how data is added, removed, or searched.
Such an approach makes the system easy to understand and easy to extend.
The application supports searching, filtering, and sorting.
Users can search people by name, filter students by minimum GPA, and sort students by GPA value.
These operations help to organize data and show only the information that is needed.
The project uses the main principles of object-oriented programming.
Encapsulation is implemented by using private fields and public methods to access them.Inheritance is used because Student and Teacher classes extend the Person class.
Polymorphism is shown when the program works with different types of people through the same base type. 
Standard Java methods toString(), equals(), and hashCode() are overridden.
This allows correct comparison of objects, avoids duplicates, and makes output clear and readable.Overall, the project is structured clearly and written in a clean and logical way.
The code is easy to read, easy to maintain, and follows the basic requirements of clean code and academic programming standards.

