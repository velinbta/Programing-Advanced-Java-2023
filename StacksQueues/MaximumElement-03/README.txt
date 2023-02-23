3. Maximum Element
You have an empty sequence, and you will be given N commands. Each command is one of the following types:
"1 X" - Push the element X into the stack.
"2" - Delete the element present at the top of the stack.
"3" - Print the maximum element in the stack.

Input
The first line of input contains an integer N, where 1 <= N <= 105.
The next N lines contain commands. All commands will be valid and in the format described.
The element X will be in the range 1 <= X <= 109.
The type of the command will be in the range 1 <= Type <= 3.

Output
For each command of type "3", print the maximum element in the stack on a new line.

Examples:

Input 1:
9
1 97
2
1 20
2
1 26
1 20
3
1 91
3

Output 1:
26
91

Comment 1:
9 commands
Push 97
Pop an element
Push 20
Pop an element
Push 26
Push 20
Print the maximum element (26)
Push 91
Print the maximum element (91)

Input 2:
7
1 81
2
1 14
2
1 14
1 47
3

Output 2:
47