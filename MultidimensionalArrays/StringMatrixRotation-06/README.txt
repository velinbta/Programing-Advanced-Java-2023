6. String Matrix Rotation
You are given a sequence of text lines. Assume these text lines form a matrix of characters (pad the missing positions with spaces to build a rectangular matrix). Write a program to rotate the matrix by 90, 180, 270, 360,.... degrees. Print the result as a sequence of strings at the console after receiving the "END" command.

Examples:
				
Input	         
hello			           	      
softuni		           	      
exam			            	          
END       				                    
	          			                         
[h][e][l][l][o][ ][ ]			                         
[s][o][f][t][u][n][i]		                         
[e][x][a][m][ ][ ][ ]

Rotate(90)	         
[e][s][h]
[x][o][e]
[a][f][l]
[m][t][l]
[ ][u][o]             
[ ][n][ ]             
[ ][i][ ]       

Rotate(180)
[ ][ ][ ][m][a][x][e]
[i][n][u][t][f][o][s]
[ ][ ][o][l][l][e][h]
				                       
Rotate(270)
[ ][i][ ]
[ ][n][ ]
[o][u][ ]
[l][t][m]
[l][f][a]
[e][o][x]
[h][s][e]

Input
The input is read from the console:
The first line holds the command in the format "Rotate(X)" where X is the degrees of the requested rotation.
The next lines contain the lines of the matrix for rotation.
The input ends with the command "END".
The input data will always be valid and in the format described. There is no need to check it explicitly.

Output
Print at the console the rotated matrix as a sequence of text lines.

Constraints
The rotation degree is a positive integer in the range [0...90000], where degrees are multiple of 90.
The number of matrix lines is in the range [1...1 000].
The matrix lines are strings of length 1 ... 1 000.
It allowed a working time: 200ms/16MB.

Examples:

Input 1:
Rotate(90)
hello
softuni
exam
END

Output 1:
esh
xoe
afl
mtl
 uo
 n 
 i 

Input 2:
Rotate(180)
hello
softuni
exam
END

Output 2:
   maxe
inutfos
  olleh

Input 3:
Rotate(270)
hello
softuni
exam
END

Output 3:
 i 
 n 
ou 
ltm
lfa
eox
hse

Input 4:
Rotate(720)
js
exam
END

Output 4:
js
exam

Input 5:
Rotate(810)
js
exam
END

Output 5:
ej
xs
a
m

Input 6:
Rotate(0)
js
exam
END

Output 6:
js
exam