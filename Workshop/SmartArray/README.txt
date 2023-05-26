SmartArray:

The SmartArray will have similar functionality to Java ArrayList. The SmartArray will work only with integers for now.
It will have the following functionality:

void add(int element) - Adds the given element to the end of the list
int get(int index) - Returns the element at the specified position in this list
int remove(int index) - Removes the element at the given index
bool contains(int element) - Checks if the list contains the given element returns (True or False)
void add(int index, int element) - Adds element at the specific index, the element at this index gets shifted to the right alongside any following elements, increasing the size
void forEach(Consumer<Integer> consumer) - Goes through each one of the elements in the list