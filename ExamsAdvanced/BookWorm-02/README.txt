2. Book Worm 
Link: https://judge.softuni.org/Contests/Practice/Index/1857#1 

You will be given a string. Then, you will be given an integer N for the size of the field with square shape. On the next N lines, you will receive the rows of the field. The player will be placed on a random position, marked with "P". On random positions there will be letters. All the empty positions will be marked with "-".
Each turn you will be given commands for the players' movement. If he moves to a letter, he consumes it, concatenates it to the initial string and the letter disappears from the field. If he tries to move outside the field, he is punished - he loses the last letter in the string, if there are any, and the players' position is not changed.
When the command "end" is received, stop the program, print all letters and the field.

Input 
On the first line, you are given the initial string 
On the second line, you are given the integer N - the size of the square matrix 
The next N lines holds the values for every row 
On each of the next lines you will get a move command

Output 
On the first line the final state of the string 
In the end print the matrix

Constraints
The size of the square matrix will be between [2...10] 
The player position will be marked with "P" 
The letters on the field will be any letter except for "P" 
Move commands will be: "up", "down", "left", "right" 
Stop command will be "end" 

Examples:

Input 1:
Hello
4
P---
Mark
-l-y
--e-
down
right
right
right
end

Output 1:
HelloMark 
---- 
---P 
-l-y 
--e-

Comment 1:
The initial string we receive is "Hello". Then we receive 4x4 field and the player is on index [0;0]. 
Then, we start receiving commands. First the player moves to [1;0], where he consumes 'M', and then all letters on the right. When we receive the "end" command, our string is "HelloMark" and the player is on index [1;3]. 

Input 2:
Initial
5
-----
t-r--
--Pa-
--S--
z--t-
up
left
left
left
end

Output 2:
Initialr 
----- 
P---- 
---a-
--S--
z--t-

Comment 2:
The initial string we receive is "Initial". Then we receive 5x5 field and the player is on index [2;2]. 
The player consumes 'r' and 't', but also tries to go out of the matrix once, so he loses the last character of his string - 't'. The string after the "end" command is "Initialr".