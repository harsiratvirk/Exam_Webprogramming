# Exam_Webprogramming

Examination in DAPE1700 - Webprogramming

Grade: 

Form of assessment: Written examination under supervision

Date: 24/05/2024

**We did not have access to an IDE to solve the tasks. The code was written directly on a white sheet, which resulted in some syntax errors in the code.**

## Tasks
We will start from the idea that we are the owners of a library and we would like to create our own online store. The tasks in this exam are interconected and our purpose is to go through all the necessary steps of developing the web platform.
Each task is solved by writing a part of the code that makes up this web application.

Sometimes it may be necessary to enter source code comments to fully answer a task. It is not necessary to implement more input validation, error handling and logging than is explicitly asked for in the tasks, but the web application must be user-friendly and provide the necessary feedback to the user. Consider that the answer fields should contain complete files with neat code, correct syntax and reasonable names of variables, classes, etc. There is no need to import Java classes or JavaScript libraries. Relevant attachments to the tasks are displayed on the left or at the top of the screen. You may need to scroll to see all attachments. In the event of any ambiguities in the assignment text, you must explain the assumptions you make as a basis for the solution in source code comments.

For the tasks that must be solved with JavaScript, you can choose whether you want to use jQuery or not. Note that we haven't gone through everything necessary to use JavaScript exclusively, so for the vast majority of people it will be necessary to use jQuery.
If you wish to use a Repository class in any of the tasks, this can be entered in the same answer field as the Controller class, but no extra points are awarded for this. All Java code can therefore be written directly in the functions of the Controller class.


### Task 1
We start from the presumption that we have already created a new, clean Java Spring Boot project where we added all the necessary dependencies for a basic CRUD(create, read, update, delete) web application.

1. Let’s create a simple UI first for user creation. All the users that want to access our premium online library need to create an account first. Create a form using HTML,CSS,JS.  Please add fields for firstname, lastname, date of birth, phone number, email address and an HTML button for sending the details to Java.  Please add custom validation for email address, phone number and date of birth -we will only allow people who are older than 18 to create an account. 

### Task 2
Create a JS method with a JS object that will take into account all the fields described in the first task( so this method will know how to save the information from the input fields).Display the information from your new object inside a console log or an alert. (Please make sure to show the proper code for activation of this  method inside the HTML button tag - you can copy the button tag you used in the first task and just add code on top of it). Also, please make a call towards a Java rest endpoint using Jquery where to send the object you just filled. ( We don't have the endpoint for now, but let's imagine it's named: "/saveUser")

### Task 3
JAVA: Create a REST controller class where you will add all the endpoints that will comunnicate with the FrontEnd.
The first endpoint should be named "/getBooks" and when called it returns a list of book objects. You need to create a model(entity) class based on the list bellow. Try to figure out what attributes you need and give them significant names. After you create the model class, return an ArrayList of books in your "/getBooks" endpoint. Please also add the sql sintax for a table that would contain the same attributes as your model class.

"The Great Gatsby" by F. Scott Fitzgerald (1925) - Rating: 4.0/5
"To Kill a Mockingbird" by Harper Lee (1960) - Rating: 4.2/5
"1984" by George Orwell (1949) - Rating: 4.5/5
"Pride and Prejudice" by Jane Austen (1813) - Rating: 4.3/5
"Animal farm" byGeorge Orwell (1951) - Rating: 4.1/5
"The Lord of the Rings" by J.R.R. Tolkien (1954) - Rating: 4.6/5

### Task 4
JAVASCRIPT: Based on the previous task, please create a method in JS that will interrogate a generic  "/getBooks" endpoint and then create an HTML table that contains all the information about the books from the previous list.

### Task 5
JAVA:  WE have discovered a problem with the list of books. We have to modify the year of publishing for Lord of The Rings. Create an endpoint in Java that will take care of updating this book. This process has a couple of steps:
1. Get a parameter when the update endpoint is called that contains the id of the book to be modified.
2. Make a call to the DB to get that specific book with all the details.
3. Modify the year.
4. Save the modifications in the DB.

(Please notice that we introduced the idea of CRUD operations with the DB which means you will have to add a Repository class in java to handle: 1. selecting specific books, 2. updating specific books)

### Task 6
JAVA: add a new endpoint to delete a specific book. Please add all the methods necessary starting from the Repository class to the Controller class and also add some custom logs.

### Task 7
JAVA: Create a new endpoint that when called returns statistical details about the list of books:
1. How many books we have
2. Is there any author that appears more than once.
3. The oldest book from the list.

All those elements should be concatenated into a text such as this: We have X amount of books. The oldest book is X....
! The code should be dinamic, which means it should be capable of taking out statiscal details about any list of books it gets as an input. More precisely you can't hardcode an answer saying you have 6 books you need to use a method to determine how many elements are inside that list. 

### Task 8
Task8: Java.  We will consider that we have implemented login logic into our application but we need to create 3 endpoints in order to handle the login process. Every time someone wants to login we need to call the login endpoint; every time someone wants to logout we need to call the logout endpoint. Starting with the ‘session’ object please create those endpoints*. We would also like to be capable of deleting some of the books we added. Let’s create a third endpoint that first checks if the user is logged in and then deletes the books that belong to the ‘Poetry’ category and are published later than the year 2000.

*When I say start with the session object, I mean that the object should be used when you call /login or /logout or /delete because that object can store valuable information.