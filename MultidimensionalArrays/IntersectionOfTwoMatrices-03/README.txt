3. Intersection of Two Matrices
Write a program that reads two char matrices (A[][] and B[][]) of the same order M * N and prints the third matrix C[][], which is filled with the intersecting elements of A and B, otherwise set the element to '*'. On the first two lines, you receive M and N, then on 2 * M lines N characters - the matrices elements.
The matrix elements may be any ASCII char except '*'.

Examples:

Input 1:
3
4
a b c d
a b c d
a b c d
k b c k
a b g d
a k c d

Output 1:
* b c * 
a b * d 
a * c d

Input 2:
5
2
1 2
3 4
5 6
7 8
9 1
0 2
3 1
1 6
7 4
1 1

Output 2:
* 2
3 *
* 6
7 *
* 1