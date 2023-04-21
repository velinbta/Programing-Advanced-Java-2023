11.* The Party Reservation Filter Module
You are a young and talented developer. The first task you need to do is to implement a filtering module to a party reservation software. First, The Party Reservation Filter Module (TPRF Module for short) is passed a list with invitations. Next, the TPRF receives a sequence of commands that specify if you need to add or remove a given filter. 
TPRF Commands are in the given format "{command;filter type;filter parameter}".
You can receive the following TPRF commands: "Add filter", "Remove filter" or "Print". The possible TPRF filter types are: "Starts with", "Ends with", "Length", and "Contains". All TPRF filter parameters will be a string (or an integer for the length filter).
The input will end with a "Print" command. See the examples below:

Examples:

Input 1:
Peter Misha Slav
Add filter;Starts with;P
Add filter;Starts with;M
Print

Output 1:
Slav

Input 2:
Peter Misha John
Add filter;Starts with;P
Add filter;Starts with;M
Remove filter;Starts with;M
Print

Output 2:
Misha John

Input 3:
Ivan Andrei Jordan Marin George Anton
Remove filter;Starts with;J
Add filter;Starts with;G
Add filter;Starts with;M
Add filter;Starts with;J
Remove filter;Starts with;M
Add filter;Contains;A
Remove filter;Starts with;J
Add filter;Length;6
Print

Output 3:
Ivan Marin