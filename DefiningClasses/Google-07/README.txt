7. Google
Google is always watching you, so it should come as no surprise that they know everything about you (even your pokemon collection), since you're really good at writing classes, Google asked you to design a Class that can hold all the information they need for people.

You will receive an unknown number of rows from the console until you receive the "End" command, on each of those lines, there will be information about a person in one of the following formats:
"{Name} company {companyName} {department} {salary}"
"{Name} pokemon {pokemonName} {pokemonType}"
"{Name} parents {parentName} {parentBirthday}"
"{Name} children {childName} {childBirthday}"
"{Name} car {carModel} {carSpeed}"

You should structure all information about a person in a class with nested subclasses. People's names are unique - there won't be 2 people with the same name, a person can also have only 1 company and car, but can have multiple parents, children, and pokemons. After the command "End" is received on the next line, you will receive a single name, you should print all information about that person. Note that information can change during the input, for instance, if we receive multiple lines which specify a person's company, only the last one should be the one remembered. The salary must be formatted to two decimal places after the separator.
Note: print the information in the format:

"{personName}
Company:
{companyName} {companyDepartment} {salary}
...
Children:
{childName} {childBirthday}
..."

Examples:

Input 1:
PeterSmith company PeshInc Management 1000.00
JohnJohnson car Trabant 30
PeterSmith pokemon Pikachu Electricity
PeterSmith parents PoshoPeshev 22/02/1920
JohnJohnson pokemon Electrode Electricity
End
JohnJohnson

Output 1:
JohnJohnson
Company:
Car:
Trabant 30
Pokemon:
Electrode Electricity
Parents:
Children:

Input 2:
GeorgeJohnson pokemon Onyx Rock
GeorgeJohnson parents SaraJohnson 13/03/1933
AlexAlexson pokemon Moltres Fire
GeorgeJohnson company JeleInc Jelior 777.77
GeorgeJohnson children SamJohnson 01/01/2001
SmithSmithon pokemon Blastoise Water
GeorgeJohnson car AudiA4 180
GeorgeJohnson pokemon Charizard Fire
End
GeorgeJohnson

Output 2:
GeorgeJohnson
Company:
JeleInc Jelior 777.77
Car:
AudiA4 180
Pokemon:
Onyx Rock
Charizard Fire
Parents:
SaraJohnson 13/03/1933
Children:
SamJohnson 01/01/2001