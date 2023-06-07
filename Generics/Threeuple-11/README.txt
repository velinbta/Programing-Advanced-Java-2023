11. *Threeuple
Now you are aware of a Class, which is probably a bad practice to use. Anyway, it is a nice example of using generics. Our next task is to create another Tuple. This time, our task is harder. 
Create a Class Threeuple. Its name tells us that it will no longer hold just a pair of objects. The task is simple, our Threeuple should hold three objects. Make it have getters and setters. You can even extend the previous class.

Input
The input consists of three lines:
The first one holds a name, an address, and a town. Format of the input: 
"{first name} {last name} {address} {town}"
The second line holds a name, beer liters, and a Boolean variable - drunk or not. Format:
"{name} {liters of beer} {drunk or not}"
The last line will hold a name, a bank balance (double), and a bank name. Format: 
"{name} {account balance} {bank name}"

Output
Print the Threeuples objects in format: "{firstElement} -> {secondElement} -> {thirdElement}"

Examples:

Input 1:
Sofia Jackson Izgrev Burgas
Max 18 drunk
Alex 0.10 DSK

Output 1:
Sofia Jackson -> Izgrev -> Burgas
Max -> 18 -> true
Alex -> 0.1 -> DSK

Input 2:
Peter Johnson Tepeto Plovdiv
Sam 18 not
Alex 0.10 NGB

Output 2:
Peter Johnson -> Tepeto -> Plovdiv
Sam -> 18 -> false
Alex -> 0.1 -> NGB