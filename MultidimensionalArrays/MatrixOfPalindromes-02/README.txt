2. Matrix of Palindromes
Write a program to generate the following matrix of palindromes of 3 letters with r rows and c columns like the one in the examples below.
Rows define the first and the last letter: row 0 -> 'a', row 1 -> 'b', row 2 -> 'c', ....
Columns + rows define the middle letter: 
column 0, row 0 -> 'a', column 1, row 0 -> 'b', column 2, row 0 -> 'c', ....
column 0, row 1 -> 'b', column 1, row 1 -> 'c', column 2, row 1 -> 'd', ....

Input
The numbers r and c stay in the first line at the input.
r and c are integers in the range [1...26].
r + c <= 27

Examples:

Input 1:
4 6

Output 1:
aaa aba aca ada aea afa
bbb bcb bdb beb bfb bgb
ccc cdc cec cfc cgc chc
ddd ded dfd dgd dhd did

Input 2:
3 2

Output 2:
aaa aba
bbb bcb
ccc cdc