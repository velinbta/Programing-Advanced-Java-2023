1. ListyIterator
Create a class ListyIterator, it should receive the collection of Strings which it will iterate, through its constructor. You should store the elements in a List. The class should have three main functions:
Move - should move an internal index position to the next index in the list, the method should return true if it successfully moved and false if there is no next index.
HasNext - should return true if there is a next index and false if the index is already at the last element of the list.
Print - should print the element at the current internal index, calling Print on a collection without elements should throw an appropriate exception with the message "Invalid Operation!".

By default, the internal index should be pointing to the 0th index of the List. Your program should support the following commands:

Command
Create {e1 e2 ...}
Return Type
void
Description
Creates a ListyIterator from the specified collection. In case of a Create command without any elements, you should create a ListyIterator with an empty collection.

Command
Move
Return Type
boolean
Description
This command should move the internal index to the next index.

Command
Print
Return Type
void
Description
This command should print the element at the current internal index.

Command
HasNext
Return Type
boolean
Description
Returns whether the collection has the next element.

Command
END
Return Type
void
Description
Stops the input.

Input
Input will come from the console as lines of commands. The first line will always be the "Create" command in the input, and it will always be the first command passed. The last command received will always be the "END" command.

Output
For every command from the input (except the "END" and "Create" commands), print the result of that command on the console, each on a new line. In the case of "Move" or "HasNext" commands, print the returned value of the method, in the case of a "Print" command you don't have to do anything additional as the method itself should already print on the console. Your program should catch any exceptions thrown because of validations (calling Print on an empty collection) and print their messages instead.

Constraints
The number of commands received will be between [1...100].

Examples:

Input 1:
Create
Print
END

Output 1:
Invalid Operation!

Input 2:
Create Peter George
HasNext
Print
Move
Print
END

Output 2:
true
Peter
true
George