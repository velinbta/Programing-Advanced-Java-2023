10. Predicate Party!
The Wire's parents are on vacation for the holidays, and he is planning an epic party at home. Unfortunately, his organizational skills are next to non-existent, so you are given the task of helping him with the reservations.
On the first line, you get a list of all the people that are coming. On the next lines, until you get the "Party!" command, you may be asked to double or remove all the people that apply to the given criteria. There are three different options: 
Everyone that has a name starts with a given string.
Everyone that has a name ending with a given string.
Everyone has a name with a given length.
When you print the guests that are coming to the party, you have to print them in ascending order. If nobody is going, print "Nobody is going to the party!". See the examples below:

Examples:

Input 1:
Peter Misha Stephan
Remove StartsWith P
Double Length 5
Party!

Output 1:
Misha, Misha, Stephan are going to the party!

Input 2:
Peter
Double StartsWith Pete
Double EndsWith eter
Party!

Output 2:
Peter, Peter, Peter, Peter are going to the party!

Input 3:
Peter
Remove StartsWith P
Party!

Output 3:
Nobody is going to the party!

Input 4:
Peter Ivan Purvan Mario Shishman Zendaya
Double StartsWith P
Double StartsWith Ma
Party!

Output 4:
Ivan, Mario, Mario, Peter, Peter, Purvan, Purvan, Shishman, Zendaya are going to the party!