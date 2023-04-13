5. Filter by Age
Write a program that reads an integer N on the first line. And on next N lines read pairs of "{name}, {age}". Then read three more lines:
Condition - "younger" or "older"
Age - Integer
Format - "name", "age" or "name age"
Depending on the condition, print the pairs in the right format.
Don't use any built-in functionality. Write your methods.

Examples:

Input 1:
5
Peter, 20
George, 18
Maria, 29
Idan, 31
Simeon, 16
older
20
name age

Output 1:
Peter - 20
Maria - 29
Idan - 31

Input 2:
5
Peter, 20
George, 18
Maria, 29
Idan, 31
Simeon, 16
younger
20
name

Output 2:
Peter
George
Simeon

Input 3:
5
Peter, 20
George, 18
Maria, 29
Idan, 31
Simeon, 16
younger
50
age

Output 3:
20
18
29
31
16