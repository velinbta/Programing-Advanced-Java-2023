7. ** Find the Real Queen
Write a program that reads (8 x 8) matrix of characters from the console. The matrix represents a chessboard with figures on it. The figures can be - queens as char 'q' or any other ASCII symbol. There will be more than one queen, but only one queen will have a valid position, which is not attacked by any other queen and does not attack any other queen. In another word, in the way of the valid queen, there are no other queens, but there may be any other ASCII symbol. Your task is to read the chessboard and find the position of the valid queen. According to chess rules, the queen can attack all the cells in horizontal verticals and both diagonals, which cross the queen position.

Examples:

Input 1:
p a p a p a p a
p a p a p a p a
p a q a p a q a
p a p a p a p a
p a p q p a p a
p a p a p a p a
p a q a p a q a
p a p a p a p a

Output 1:
4 3

Input 2:
1 q q q 1 q q q
q 1 q q 1 q q 1
q q 1 q 1 q 1 q
q q q 1 1 1 q q
1 1 1 1 q 1 1 1
q q q 1 1 1 q q
q q 1 q 1 q 1 q
q 1 q q 1 q q 1 

Output 2:
4 4

Input 3:
1 1 1 1 1 2 1 1
1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1
1 1 1 q 1 1 1 1
1 1 1 1 q 1 1 1
1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1
1 1 q 1 1 1 1 1

Output 3:
7 2