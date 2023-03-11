5. Matrix Shuffling
Write a program which reads a string matrix from the console and performs certain operations with its elements. User input is provided similarly to the problems above - first, you read the dimensions and then the data. 
Your program should then receive commands in the format: "swap row1 col1 row2c col2" where row1, row2, col1, col2 are coordinates in the matrix. For a command to be valid, it should start with the "swap" keyword along with four valid coordinates (no more, no less). You should swap the values at the given coordinates (cell [row1, col1] with cell [row2, col2]) and print the matrix at each step (this you'll be able to check if the operation was performed correctly). 
If the command is not valid (doesn't contain the keyword "swap", has fewer or more coordinates entered, or the given coordinates do not exist), print "Invalid input!" and move on to the next command. Your program should finish when the string "END" is entered.

Examples:

Input 1:
2 3
1 2 3
4 5 6
swap 0 0 1 1
swap 10 9 8 7
swap 0 1 1 0
END

Output 1:
5 2 3
4 1 6
Invalid input!
5 4 3
2 1 6

Input 2:
1 2
Hello World
0 0 0 1
swap 0 0 0 1
swap 0 1 0 0
END

Output 2:
Invalid input!
World Hello
Hello World