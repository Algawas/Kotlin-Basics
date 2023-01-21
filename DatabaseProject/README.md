# Kotlin Bootcamp
Project scenario:
Create an application that consist of five pages

First page is welcome page that ask the user to choose between login or register.

Login page asks the client to sign in with the phone number. If the number is not existed then show a message that notifies the client to go to the register page otherwise just let the client proceed to the home page.

Register page asks the client to register by entering the phone number, email and name. When the client is already existed show a message that notifies the client to go to the login page otherwise save these information to the database (user table) then proceed to the home page.

Home page contains recycler view and plus button in the toolbar. Recycler view is a list of all the tasks (Todo) that the user had entered. When the plus button is clicked navigate to add page.

Add page is simple page which has the name of the task and if it's completed or not. After the user finish entering these details, added these information to the database (task table) then navigate back to the home page to the show all the tasks.

Abstract:
Database contains two tables (User, Task)
Welcome page contains text view (Welcome message) and two buttons (Login, Register)
Login page contains edit text (Phone number)
Register page contains three edit texts (Phone Number, Email, Name)
Home page contains recycler view (List of tasks) and toolbar (Add button)
Add page contains edit text (task) and an option to choose (completed, not completed)
