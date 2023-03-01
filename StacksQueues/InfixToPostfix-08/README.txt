8. *Infix to Postfix
Mathematical expressions are written in an infix notations, for example "5 / ( 3 + 2 )". However, this kind of notation is not efficient for computer processing, as you first need to evaluate the expression inside the brackets, so there is a lot of back and forth movement. A more suitable approach is to convert it into the so-called postfix notations (also called Reverse Polish Notation(search internet)), in which the expression is evaluated from left to right, for example, "3 2 + 5 /".
Implement an algorithm that converts the mathematical expression from infix notation into a postfix notation. Use the famous Shunting-yard algorithm(search internet).

Input
You will receive an expression on a single line consisting of tokens.
Tokens could be numbers 0-9, variables a-z, operators +, -, *, / and brackets ( or ).
Each token is separated by exactly one space.

Output
The output should be on a single line, consisting of tokens separated by exactly one space.

Examples:

Input 1:
5 / ( 3 + 2 )

Output 1:
5 3 2 + /

Input 2:
1 + 2 + 3

Output 2:
1 2 + 3 +

Input 3:
7 + 13 / ( 12 - 4 )

Output 3:
7 13 12 4 - / +

Input 4:
( 3 + x ) - y

Output 4:
3 x + y -

Input 5:
7 + 13 / ( 12 - 4 ) + 7 + 13 / ( 12 - 4 )

Output 5:
7 13 12 4 - / + 7 + 13 12 4 - / +

Input 6:
7 * 13 / ( 12 * 4 ) * 7 / 13 / ( 12 * 4 )

Output 6:
7 13 * 12 4 * / 7 * 13 / 12 4 * /