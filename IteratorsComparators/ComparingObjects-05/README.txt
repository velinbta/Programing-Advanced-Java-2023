5. Comparing Objects
There is a Comparable interface, but probably you already know. Your task is simple. Create a Class Person. Each person should have a name, age, and town. You should implement the interface - Comparable and try to override the compareTo method.
When you compare two people, first you should compare their names, after that - their age and last but not least - compare their town.

Input
On single lines, you will be given people in the format:
"{name} {age} {town}"
Collect them till you receive "END".
After that, you will receive an integer N - the Nth person in your collection.

Output
On the single output line, you should bring statistics, how many people are equal to him, how many people are not equal to him, and the total number of people in your collection.
Format:
"{number of equal people} {number of not equal people} {total number of people}" 
If there are no equal people, print: "No matches".

Constraints
Names, ages, and addresses will be valid.
Input number will be always a valid integer in the range [2...100].

Examples:

Input 1:
Peter 22 Varna
George 14 Sofia
END
2

Output 1:
No matches

Input 2:
Peter 22 Varna
George 22 Varna
George 22 Varna
END
2

Output 2:
2 1 3