2. Company Roster
Define a class Employee that holds the following information: name, salary, position, department, email, and age. The name, salary, position, and department are mandatory, while the rest are optional. 
Your task is to write a program that takes N lines of information about employees from the console and calculates the department with the highest average salary, and prints for each employee in that department his name, salary, email, and age - sorted by salary in descending order. If an employee doesn't have an email - in place of that field, you should print "n/a" instead, if he doesn't have an age - print "-1" instead. Print in the following format:

"Highest Average Salary: {department}
{name1} {salary1} {email1} {age1}
{name2} {salary2} {email2} {age2}
.....
{nameN} {salaryN} {emailN} {ageN}"
The salary should be printed to two decimal places after the separator.
Hint: You can define a Department class that holds a list of employees.

Examples:

Input 1:
4
Peter 120.00 Dev Development peter@abv.bg 28
Tina 333.33 Manager Marketing 33
Sam 840.20 ProjectLeader Development sam@sam.com
George 0.20 Freeloader Nowhere 18

Output 1:
Highest Average Salary: Development
Sam 840.20 sam@sam.com -1
Peter 120.00 peter@abv.bg 28

Input 2:
6
Silver 496.37 Temp Coding silver@yahoo.com
Sam 610.13 Manager Sales
John 609.99 Manager Sales john@abv.bg 44
Venci 0.02 Director BeerDrinking beer@beer.br 23
Andre 700.00 Director Coding
Popeye 13.3333 Sailor SpinachGroup popeye@pop.ey

Output 2:
Highest Average Salary: Sales
Sam 610.13 n/a -1
John 609.99 john@abv.bg 44

Input 3:
8
Silver 496.37 Temp Coding silver@yahoo.com
Sam 610.13 Manager Sales
John 609.99 Manager Sales john@abv.bg 44
Venci 0.02 Director BeerDrinking beer@beer.br 23
Andre 700.00 Director Coding
Popeye 13.3333 Sailor SpinachGroup popeye@pop.ey
Guz 555.37 Temp Coding silver@yahoo.com
Sam 444.13 Manager Sales

Output 3:
Highest Average Salary: Coding
Andre 700.00 n/a -1
Guz 555.37 silver@yahoo.com -1
Silver 496.37 silver@yahoo.com -1