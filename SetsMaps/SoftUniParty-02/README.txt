2. SoftUni Party
There is a party in SoftUni. Many guests are invited, and they are two types: VIP and regular. 
When a guest comes, you have to check if he/she exists on any of the two reservation lists. All reservation numbers will be with 8 chars. All VIP numbers start with a digit.

There will be 2 command lines:
First is "PARTY" - the party is on, and guests are coming.
The second is "END" - then the party is over, and no more guests will come.
The output shows all guests who didn't come to the party (VIP must be first).

Examples:

Input 1:
7IK9Yo0h
9NoBUajQ
Ce8vwPmE
SVQXQCbc
tSzE5t0p
PARTY
9NoBUajQ
Ce8vwPmE
SVQXQCbc
END

Output 1:
2
7IK9Yo0h
tSzE5t0p

Input 2:
m8rfQBvl
fc1oZCE0
UgffRkOn
7ugX7bm0
9CQBGUeJ
2FQZT3uC
dziNz78I
mdSGyQCJ
LjcVpmDL
fPXNHpm1
HTTbwRmM
B5yTkMQi
8N0FThqG
xys2FYzn
MDzcM9ZK
PARTY
2FQZT3uC
dziNz78I
mdSGyQCJ
LjcVpmDL
fPXNHpm1
HTTbwRmM
B5yTkMQi
8N0FThqG
m8rfQBvl
fc1oZCE0
UgffRkOn
7ugX7bm0
9CQBGUeJ
END

Output 2:
2
MDzcM9ZK
xys2FYzn