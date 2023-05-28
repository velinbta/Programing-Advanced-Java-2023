2. Generic Array Creator
Create a class ArrayCreator with a method and a single overload to it:

static T[] create(int length, T defaultItem)
static T[] create(Class<T> clazz, int length, T defaultItem)
The method should return an array with the given length, and every element should be set to the given default item.

Examples:

String[] strings = ArrayCreator.create(10, "none");

Integer[] integers = ArrayCreator.create(Integer.class, 10, 0);