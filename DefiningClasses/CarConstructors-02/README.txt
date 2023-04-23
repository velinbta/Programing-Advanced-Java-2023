2. Car Constructors
Create a class named Car.
Brand: String
Model: String
Horsepower: int

Make proper constructors for the Car class, so you can create car objects with a different type of input information.
If you miss information about the field of type String set the value to "unknown", and for an integer, fieldset -1.

Read information about cars the same way as the previous task, however, this time uses constructors to create the objects, not creating an object with the default constructor. You should be able to handle different types of input, the format will be the same as the previous task, but this time some data may be missing. For example, you can get only the car brand - which means you have to set the car model to "unknown" and the Horsepower value to -1. There will be lines with complete car data, declare constructor which sets all the fields.
You have to add the car objects to a collection of your choice and print the data as in the previous task. The input will always have one or three elements on each line.

Test the Program
On each line you will read car info in the following format "{brand} {model} {horsePower}" separated by single space.

This method should return the info about any car object in the following format:
"The car is: {brand} {model} - {horsePower} HP."

Examples:

Input 1:
2
Chevrolet
Golf Polo 49

Output 1:
The car is: Chevrolet unknown - -1 HP.
The car is: Golf Polo - 49 HP.

Input 2:
4
Was
Only For 3
Test Purposes 4
No Way 5

Output 2:
The car is: Was unknown - -1 HP.
The car is: Only For - 3 HP.
The car is: Test Purposes - 4 HP.
The car is: No Way - 5 HP.