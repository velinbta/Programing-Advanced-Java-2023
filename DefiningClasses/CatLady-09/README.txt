9. ** Cat Lady
Sara has many cats in her house of various breeds, since some breeds have specific characteristics, Sara needs some way to catalog the cats. Help her by creating a class hierarchy with all her breeds of cats so that she can easily check their characteristics.
Sara has 3 specific breeds of cats "Siamese", "Cymric" and the very famous Bulgarian breed "Street Extraordinaire", each breed has a specific characteristic about which information should be kept. For the Siamese cats their ear size should be kept, for Cymric cats - the length of their fur in millimeters and for the Street Extraordinaire, the decibels of their meowing during the night.
From the console, you will receive lines of cat information until the command "End" is received, the information will come in one of the following formats:
"Siamese {name} {earSize}"
"Cymric {name} {furLength}"
"StreetExtraordinaire {name} {decibelsOfMeows}"

On the last line, after the "End" command, you will receive the name of a cat, and you should print that cat. Round the numbers two digits after the decimal separator.

Examples:

Input 1:
StreetExtraordinaire Maca 85
Siamese Sim 4
Cymric Tom 28
End
Tom

Output 1:
Cymric Tom 28.00

Input 2:
StreetExtraordinaire Koti 80
StreetExtraordinaire Maca 100
Cymric Tim 31
End
Maca

Output 2:
StreetExtraordinaire Maca 100.00