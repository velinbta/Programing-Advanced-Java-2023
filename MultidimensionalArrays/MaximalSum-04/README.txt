4. Maximal Sum
Write a program that reads a rectangular integer matrix of size N x M and finds the square 3 x 3 with a maximal sum of its elements.

Input
On the first line, you will receive the rows N and columns M. 
On the next N lines, you will receive each row with its elements.
Print the elements of the 3 x 3 square as a matrix, along with their sum. See the format of the output below.

Examples:

Input 1:
4 5
1 5 5 2 4
2 1 4 14 3
3 7 11 2 8
4 8 12 16 4

Output 1:
Sum = 75
1 4 14
7 11 2
8 12 16

Comment 1:
1   5    5     2      4
2   [1]  [4]   [14]   3
3   [7]  [11]  [2]    8
4   [8]  [12]  [16]   4


Input 2:
5 6
1 0 4 3 1 1 
1 3 1 3 0 4 
6 4 1 2 5 6 
2 2 1 5 4 1 
3 3 3 6 0 5

Output 2:
Sum = 34
2 5 6
5 4 1
6 0 5