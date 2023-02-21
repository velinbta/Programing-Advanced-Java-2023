7. Math Potato
Rework the previous problem so that a child is removed only on a composite (not prime) cycle (cycles start from 1).  (Accept that 1 a composite number <- Which was not mentioned previously) 

Previous Problem:
-> Hot potato is a game in which children form a circle and start passing a hot potato. The counting starts with the first kid. Every nth toss, the child left with the potato leaves the game. When a kid leaves the game, it passes the potato forward. This continues repeating until there is only one kid left.
Create a program that simulates the game of Hot Potato. Print every kid that is removed from the circle. In the end, print the kid that is left last. <-

(-> What that problem did not say is in order to succeed we must use PriorityQueue)!

If a cycle is prime, print the child's name.
As before, print the name of the child that is left last.

Examples:

Input 1:
Maria Peter George
2

Output 1:
Removed George
Prime Maria
Prime Maria
Removed Maria
Last is Peter

Input 2:
George Peter Misha Sara Kendal
10

Output 2:
Removed George
Prime Kendal
Prime Kendal
Removed Kendal
Prime Misha
Removed Misha
Prime Peter
Removed Peter
Last is Sara