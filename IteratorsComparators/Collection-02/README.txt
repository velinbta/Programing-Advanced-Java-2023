2. Collection
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

Extend the problem by implementing the Iterable interface, and implement all methods desired by the interface manually. Add a new method to the class PrintAll(), the method should foreach the collection and print all elements on a single line separated by a space.

Input
Input will come from the console as lines of commands. The first line will always be the "Create" command in the input and it will always be the first command passed. The last command received will always be the "END" command.

Output
For every command from the input (except the "END" and "Create" commands) print the result of that command on the console, each on a new line. In the case of Move or HasNext commands print the returned value of the method, in the case of a "Print" command, you don't have to do anything additional as the method itself should already print on the console. In the case of a "PrintAll" command, you should print all elements on a single line separated by spaces. Your program should catch any exceptions thrown because of validations and print their messages instead.

Constraints
Do not use the built-in iterators!
The number of commands received will be between [1...100].

Examples:

Input 1:
Create Sam George Peter
PrintAll
Move
Move
Print
HasNext
END

Output 1:
Sam George Peter
true
true
Peter
false

Input 2:
Create 1 2 3 4 5
Move
PrintAll
END

Output 2:
true
1 2 3 4 5