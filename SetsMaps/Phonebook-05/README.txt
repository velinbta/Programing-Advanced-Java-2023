5. Phonebook
Write a program that receives some info from the console about people and their phone numbers.
You are free to choose how the data is entered. Each entry should have just one name and one number (both of them strings). If you receive a name that already exists in the phonebook, simply update its number.

After filling this simple phonebook, upon receiving the command "search", your program should be able to perform a search of contact by name and print her details in the format "{name} -> {number}". In case the contact isn't found, print "Contact {name} does not exist.".

Examples:

Input 1:
John-0888080808
search
Maria
John
stop

Output 1:
Contact Maria does not exist.
John -> 0888080808

Input 2:
John-00359888001122
Peter-0040333111000
George-0049112233
Samuel-0047123123123
search
Samuel
samuel
PeTeR
Peter
stop

Output 2:
Samuel -> 0047123123123
Contact samuel does not exist.
Contact PeTeR does not exist.
Peter -> 0040333111000