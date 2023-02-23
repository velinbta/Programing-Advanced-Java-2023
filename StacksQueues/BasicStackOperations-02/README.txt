2. Basic Stack Operations
You will be given an integer N representing the number of elements to push into the stack, an integer S representing the number of elements to pop from the stack, and an integer X, an element that you should check whether is present in the stack. If it is, print "true" on the console. If it's not, print the smallest element currently present in the stack.

Input
On the first line, you will be given N, S, and X separated by a single space. 
On the next line, you will be given a line of numbers separated by one or more white spaces.

Output
On a single line print, either "true" if X is present in the stack, otherwise, print the smallest element in the stack.
If the stack is empty - print 0.

Examples:

Input 1:
5 2 13
1 13 45 32 4

Output 1:
true

Comment 1:
We have to push 5 elements. Then we pop 2 of them. Finally, we have to check whether 13 is present in the stack. Since it is, we print true.

Input 2:
4 1 666
420 69 13 666

Output 2:
13

Comment 2:
Pop one element (666) and then check if 666 is present in the stack. It's not, so print the smallest element (13).

Input 3:
3 3 90
90 90 90

Output 3:
0