8. Custom List Sorter
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

Note: For the Judge tests, use String as T.

Examples:

Input 1:
Add cc
Add bb
Add aa
Sort
Print
END

Output 1:
aa
bb
cc

Input 2:
Add Peter
Add George
Max
Sort
Print
END

Output 2:
Peter
George
Peter