# MasGlobal-Java Dev Test
Medellin recruitment process for MasGlobal Consulting:

- API: http://masglobaltestapi.azurewebsites.net/api/employees

- Requirements:
1. Create a data access layer that consumes the following API as your data repository.

2. Create a Business Logic layer so you can retrieve the employees’ information including a calculated Annual Salary following these rules:
  ▪ Create your DTO (Data Transfer Object) Classes depending on the type of Contract that a given employee has (Hourly or Monthly).
  ▪ Make use of a Factory pattern to create the concrete classes so you can calculate the salary depending on the type of contract.
  ▪ Employees can have to 2 types of Contracts: Hourly Salary Contract and Monthly Salary Contract.
    o For Hourly Salary Employees the Annual Salary is: 120 * HourlySalary * 12
    o For Monthly Salary Employees the Annual Salary is: MonthtlySalary * 12

3. Create a “WEB SERVICE”/API that can return information for a given employee or
multiple employees.

4. Create a web page (view) using the following guidelines:
You can use the front-end technologies you are familiar with (JSP, JavaScript, HTML, etc.)
  - The view must contain a textbox, so the user can type the id of a particular employee.
  - The view must contain a Get Employees button
  - If the textbox is empty, when the Get Employees button is clicked, retrieve the information for all the employees including the calculated Annual Salaries by calling your API
  - If the textbox has the id of a given employee, retrieve only the information for that particular employee including the calculated Annual Salary by calling your API
  - Information must be displayed in a table.
  
5. (OPTIONAL) BONUS POINT: Create one Unit test to test one of the methods of your Business Logic Layer.

6. (OPTIONAL) BONUS POINT: Use Spring Framework in any part of your implementation and justify its use.
