4. List Utilities
Create a class ListUtils that you will use through several other exercises:
The class should have two static methods:

T getMin(List<T> list)
T getMax(List<T> list)
The methods should throw IllegalArgumentException if an empty list is passed.

Examples:

List<Integer> integers = new ArrayList<>();
Collections.addAll(integers, 1, 2, 18, 2, -1);

Integer maxInteger = ListUtils.getMax(integers);

List<String> strings = new ArrayList<>();
Collections.addAll(strings, "a", "b", "c");

String minString = ListUtils.getMin(strings);