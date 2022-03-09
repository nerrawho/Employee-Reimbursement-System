# Employee Reimbursement System

## Project Description
---

A website that allows employees to submit reimbursements and managers that can resolve them.
Basic frontend created using HTML/CSS/JS and some bootstrap. Backend created with Java with Javalin as our
tool for creating HTTP requests. PostgreSQL used for databasing. 

## Technologies Used
---
* Java8
* Gradle
* Mockito/JUnit
* Javalin
* Postman
* PostgreSQL
* HTML/CSS
* Javascript
* Google Cloud Platform

## Features
---
* Login/Logout
* Individual dashboard for employee and manager
* Submit a reimbursement request
* View pending reimbursements
* View resolved reimbursements
* View all pending reimbursements by employee
* View all employees

To-do list:

* Better test coverage for backend
* Improve on styling

## Getting Started
---
1. Start by creating a local repository.
2. Git bash into the repository and input:
```
git clone https://github.com/nerrawho/Employee-Reimbursement-System.git
```

3. After cloning open the project into IntelliJ and wait for gradle to complete building.
4. Connect a database from the backend through ConnectionUtil.class.
5. Run **JavalinDriver.class** to start the backend.



## Usage
---
The website requires a user to log in either as a manager or an employee, the user accounts would be pre-made. Upong logging in the user will be redirected to either a manager dashboard or employee dashboard. 


The employee can submit a pending reimbursement as well as view his resolved reimbursements.

The manager is able to approve/deny reimbursements. View all employees and view all pending reimbursements.

Clicking on the logout button will redirect the user back to the login page.

## Contributors
---
* nerrawho
* Mimi-AB



