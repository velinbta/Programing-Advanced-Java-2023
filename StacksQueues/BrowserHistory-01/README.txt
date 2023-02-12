1. Browser History
Write a program that takes two types of browser instructions:
Normal navigation: a URL is set, given by a string;
The string "back" sets the current URL to the last set URL

After each instruction, the program should print the current URL. If the back instruction can't be executed, print 
"no previous URLs". The input ends with the "Home" command, and then you simply have to stop the program.

Examples:

Input 1:
https//softuni.bg/
back
https//softuni.bg/trainings/courses
back
https//softuni.bg/trainings/2056
back
https//softuni.bg/trainings/live
https//softuni.bg/trainings/live/details
Home

Output 1:
https//softuni.bg/
no previous URLs
https//softuni.bg/trainings/courses
https//softuni.bg/
https//softuni.bg/trainings/2056
https//softuni.bg/
https//softuni.bg/trainings/live
https//softuni.bg/trainings/live/details

Input 2:
https//google.bg/
https//google.bg/softuni
back
back
https//google.bg/java/advanced
back
https//google.bg/java/oop
Home

Output 2:
https//google.bg/
https//google.bg/softuni
https//google.bg/
no previous URLs
https//google.bg/java/advanced
https//google.bg/
https//google.bg/java/oop