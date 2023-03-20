1. Parking Lot
Write a program that:
Records car numbers for every car that enters the parking lot.
Removes car number when the car is out.
When the parking lot is empty, print "Parking Lot is Empty".

Input
The input will be a string in the format "{direction, carNumber}".
The input ends with the string "END".

Output
Print the output with all car numbers which are in the parking lot.

Examples:

Input 1:
IN, CA2844AA
IN, CA1234TA
OUT, CA2844AA
IN, CA9999TT
IN, CA2866HI
OUT, CA1234TA
IN, CA2844AA
OUT, CA2866HI
IN, CA9876HH
IN, CA2822UU
END

Output 1:
CA9999TT
CA2844AA
CA9876HH
CA2822UU

Input 2:
IN, CA2844AA
IN, CA1234TA
OUT, CA2844AA
OUT, CA1234TA
END

Output 2:
Parking Lot is Empty