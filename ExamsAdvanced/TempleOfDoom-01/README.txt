01. Temple of Doom

Harry will have to discover an important artifact in a cursed temple. Relying on the inscriptions at the entrance, Harry realizes that he will have to face unprecedented challenges. He must take all the useful things that he has in his truck...
There will be given two sequences of integers, representing tools and substances that he has at his disposal. There will also be a third sequence of integers, representing all challenges in the temple.

Your task is to take the first tool from the tools sequence and the last substance from the substances sequence. Multiply the values and check the result.
If the calculated result is equal to any of the elements from the challenges sequence, the challenge is resolved. You need to remove both the tool and the substance from their sequences. The challenge should also be removed from its sequence.
If the calculated result is not equal to any of the elements from the challenges sequence, the challenge is not resolved:
Increase the value of the tool element by 1 and move the element to the back of the tools' sequence.
Decrease the value of the substance element by 1 and return the element to the substance's sequence. If the value of the substance element reaches 0, remove it from the sequence.

If Harry has no substances or tools left (the substances sequence is empty) but has more challenges to resolve, he is lost in the temple forever. End the program and print on the console the following message:
"Harry is lost in the temple. Oblivion awaits him."
If Harry manages to pass all the challenges, he will find the artifact. End the program and print on the console the following message:
"Harry found an ostracon, which is dated to the 6th century BCE."

Input
The first line will represent the tools that Harry has at his disposal - integers, separated by a single space.
The second line will represent the substances that Harry has at his disposal - integers, separated by a single space.
The third line will represent the challenges that Harry will have to resolve - integers, separated by a single space.

Output
On the first line print on the console the appropriate message, among the following:
"Harry is lost in the temple. Oblivion awaits him."
"Harry found an ostracon, which is dated to the 6th century BCE."

On the next three lines, print on the console the elements of the non-empty sequences, in the following format:
"Tools: element1, element2, element3 ... elementn"
"Substances: element1, element2, element3 ... elementn"
"Challenges: element1, element2, element3 ... elementn"

Constraints
All the given numbers will be valid integers in the range [1...100].
There will be no negative inputs.

Examples:

Input 1:
2 4 6 8
11 3 5 7 9
24 28 18 30

Output 1:
Harry found an ostracon, which is dated to the 6th century BCE.
Substances: 11

Comment 1:
1)	
2 4 6 8
11 3 5 7 9
24 28 18 30
2 * 9 = 18
Harry resolves one of the challenges. Remove both the tool value and the substance value from their sequences. Remove the challenge value from the challenges sequence.
2)	
4 6 8
11 3 5 7
24 28 30
4 * 7 = 28
Harry resolves one more of the challenges. Remove both the tool value and the substance value from their sequences. Remove the challenge value from the challenges sequence.
3)	
6 8
11 3 5
24 30
6 * 5 = 30
Harry resolves one more of the challenges. Remove both the tool value and the substance value from their sequences. Remove the challenge value from the challenges sequence.
4)	
8
11 3
24
8 * 3 = 24
Harry resolves one of the challenges. Remove both the tool value and the substance value from their sequences. Remove the challenge value from the challenges sequence.
5)	
The challenges sequence remains empty, so the program ends. The only sequence containing any element is the substances sequence, so it should be presented in the console output.

Input 2:
13 7 4 22 11 15 20
3 2 1
12 10 5

Output 2:
Harry is lost in the temple. Oblivion awaits him.
Tools: 20, 14, 8, 5, 23, 12, 16
Challenges: 12, 10, 5

Comment 2:
1)	
13 7 4 22 11 15 20
3 2 1
12 10 5
13 * 1 = 13
No element from the challenges sequence is equal to the calculated result. Increase the tool value by 1 and add it to the back of the tools sequence. Decrease the substance value by 1. It becomes equal to 0, so it should be removed from the substances sequence. 
2)	
7 4 22 11 15 20 14
3 2
12 10 5
7 * 2 = 14
No element from the challenges sequence is equal to the calculated result. Increase the tool value by 1 and add it to the back of the tools sequence. Decrease the substance value by 1.
3)	
4 22 11 15 20 14 8
3 1
12 10 5
4 * 1 = 4
No element from the challenges sequence is equal to the calculated result. Increase the tool value by 1 and add it to the back of the tools sequence. Decrease the substance value by 1. It becomes equal to 0, so it should be removed from the substances sequence.
4)	
22 11 15 20 14 8 5
3
12 10 5
22 * 3 = 66
No element from the challenges sequence is equal to the calculated result. Increase the tool value by 1 and add it to the back of the tools sequence. Decrease the substance value by 1.
5)	
11 15 20 14 8 5 23
2
12 10 5
11 * 2 = 22
No element from the challenges sequence is equal to the calculated result. Increase the tool value by 1 and add it to the back of the tools sequence. Decrease the substance value by 1.
6)	
15 20 14 8 5 23 12
1
12 10 5
15 * 1 = 15
No element from the challenges sequence is equal to the calculated result. Increase the tool value by 1 and add it to the back of the tools sequence. Decrease the substance value by 1. It becomes equal to 0, so it should be removed from the substances sequence.
7)	
20 14 8 5 23 12 16

12 10 5
8)	
The substances sequence remains empty, so the program ends. The sequences containing any element are the tools sequence and the challenges sequence, so they should be presented in the console output.
