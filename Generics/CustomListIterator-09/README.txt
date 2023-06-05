9. *Custom List Iterator
Create a generic data structure that can store any type that can be compared. Implement functions:
void add(T element)
T remove(int index)
boolean contains(T element)
void swap(int index, int index)
int countGreaterThan(T element)
T getMax()
T getMin()

Create a command interpreter that reads commands and modifies the custom list that you have created. Implement the commands:
Add {element} - Adds the given element to the end of the list.
Remove {index} - Removes the element at the given index.
Contains {element} - Prints if the list contains the given element (true or false).
Swap {index1} {index2} - Swaps the elements at the given indexes.
Greater {element} - Counts the elements that are greater than the given element and prints their count
Max - Prints the maximum element in the list.
Min - Prints the minimum element in the list.
Print - Prints all elements in the list, each on a separate line.
END - stops the reading of commands.

Create an additional Sorter class. It should have a single static method sort() which can sort objects of type CustomList containing any type that can be compared. Extend the command list to support one additional command Sort:
Sort - Sort the elements in the list in ascending order.

Extend your custom list class by making it implement Iterable. This should allow you to iterate your list in a foreach statement.

Note: For the Judge tests, use String as T.

Examples:

Input 1:
Add aa
Add bb
Add cc
Max
Min
Greater aa
Swap 0 2
Contains aa
Print
END

Output 1:
cc
aa
2
true
cc
bb
aa

Input 2:
Add Peter
Add George
Swap 0 0
Swap 1 1
Swap 0 1
Swap 1 0
Swap 0 1
Print
END

Output 2:
George
Peter