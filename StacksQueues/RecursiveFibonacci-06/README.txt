6. Recursive Fibonacci
Each member of the Fibonacci sequence is calculated from the sum of the two previous members. The first two elements are 1, 1. Therefore, the sequence goes like 1, 1, 2, 3, 5, 8, 13, 21, 34...

The following sequence can be generated with an array, but that's easy, so your task is to implement it recursively.
If the function getFibonacci(n) returns the nth Fibonacci number, we can express it using getFibonacci(n) = getFibonacci(n-1) + getFibonacci(n-2).
However, this will never end, and a Stack Overflow Exception is thrown in a few seconds. For the recursion to stop, it has to have a "bottom". The bottom of the recursion is getFibonacci(1), and should return 1. The same goes for getFibonacci(0).

Input
On the only line in the input, the user should enter the wanted Fibonacci number N where 1 <= N <= 49.
Output
The output should be the nth Fibonacci number counting from 0.

Examples:

Input 1:
5

Output 1:
8

Input 2:
10

Output 2:
89

Input 3:
21

Output 3:
17711