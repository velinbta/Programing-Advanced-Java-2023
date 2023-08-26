8. *Pet Clinics
You are a young and ambitious owner of Pet Clinics Holding. You ask your employees to create a program that will store all information about the pets in the database. Each pet should have a name, age, and kind.
Your application should support a few basic operations such as creating a pet, creating a clinic, adding a pet to a clinic, releasing a pet from a clinic, printing information about a specific room in a clinic, or printing information about all rooms in a clinic.
Clinics should have an odd number of rooms, attempting to create a clinic with an even number should fail and throw an appropriate exception.

Accommodation Order
For example, let us take a look at a clinic with 5 rooms. 
The first room where a pet will be treated is the central one (room 3).
Therefore, the order in which an animal is entering is: the first animal is going to the centre(3) room, and after that, the next pets are entering first to the left (2) and then to the right (4) room. 
The last rooms in which pets can enter are room 1 and room 5. In case a room is already occupied, we skip it and go to the next room in the above order. Your task is to model the application and make it support some commands. 
The first pet enters room 3. 					-> 	1 2 (3) 4 5
After that, the next pet enters room 2. 			-> 	1 (2) 3 4 5
The third pet would enter room 4. 				-> 	1 2 3 (4) 5
And the last two pets would be going to rooms - 1 and 5. 	->	(1) 2 3 4 (5)

Now when we have covered adding the pets, it is time to find a way to release them. The process of releasing them is not so simple, when the release method is called, we start from the centre room (3) and continue right (4, 5... and so on) until we find a pet or reach the last room. 
If we reach the last room, we start from the first (1) and again move right until we reach the centre room (3). If a pet is found, we remove it from the collection, stop further search and return true, if a pet is NOT found, the operation returns false.
When a print command for a room is called, if the room contains a pet, we print the pet on a single line in the format "{pet name} {pet age} {pet kind}". Alternatively, if the room is empty, print "Room empty" instead. When a print command for a clinic is called, it should print all rooms in the clinic in order of their number.

Commands: Return Type: Purpose:

Create Pet {name} {age} {kind}		void		Creates a pet with the specified name and age.

Create Clinic {name} {rooms}		void		Creates a Clinic with the specified name and number of rooms.
(if the rooms are not odd, throw an exception)

Add {pet's name} {clinic's name}	boolean 	This command should add the given pet to the specified clinic.
(true if the operation is successful and false if it isn't).

Release {clinic's name}		       boolean		This command should release an animal from the specified clinic.
(true if the operation is successful and false if it isn't).

HasEmptyRooms {clinic's name}		boolean		Returns whether the clinic has any empty rooms.
(true if it has and false if it doesn't).

Print {clinic's name}		void		This command should print each room in the specified clinic, ordered by room number. 

Print {clinic's name} {room}		void		Prints on a single line the content of the specified room.

Input
On the first line, you will be given an integer N - the number of commands you will receive. On each of the next N lines, you will receive a command.

Output
For each command with a boolean return type received through the input, you should print its return value on a separate line. In case of a method throwing an exception (such as trying to create a clinic with an even number of rooms or trying to add a pet that doesn't exist), you should catch the exceptions and instead print "Invalid Operation!". 
The "Print" command with a clinic and a room should print information for that room in the format specified above. 
The "Print" command with only a clinic should print information for each room in the clinic in order of their numbers.

Constraints
The number of commands N - will be a valid integer between [1...1000], no need to check it explicitly.
Pet names, Clinic names, and kinds will be strings consisting only of alphabetical characters with a length between [1...50] characters.
Pet age will be a positive integer between [1...100].
Clinic rooms will be a positive integer between [1...101].
Room number in a "Print" command will always be between 1 and the number of rooms in that Clinic.
Input will consist only of correct commands and always have the correct type of parameters.

Examples:

Input 1:
9
Create Pet George 7 Cat
Create Clinic Sofia 4
Create Clinic Sofiq 1
HasEmptyRooms Sofiq
Release Sofiq
Add George Sofiq
HasEmptyRooms Sofiq
Create Pet Sharo 2 Dog
Add Sharo Sofiq

Output 1:
Invalid Operation!
true
false
true
false
false

Input 2:
8
Create Pet George 7 Cat
Create Pet Sam 1 Cata
Create Clinic Rim 5
Add George Rim
Add Sam Rim
Print Rim 3
Release Rim
Print Rim

Output 2:
true
true
George 7 Cat
true
Room empty
Sam 1 Cata
Room empty
Room empty
Room empty