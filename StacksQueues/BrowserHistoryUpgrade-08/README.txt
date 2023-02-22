8. Browser History Upgrade
Extend "Browser History" with a "forward" instruction, which visits URLs that were navigated away from by "back".
Each forward instruction visits the next most recent such URL. If normal navigation happens, all potential forward URLs are removed until a new back instruction is given if the forward instruction can't be executed, print 
"no next URLs".

-> 1 Browser History
Write a program that takes two types of browser instructions:
Normal navigation: a URL is set, given by a string;
The string "back" sets the current URL to the last set URL
After each instruction, the program should print the current URL. If the back instruction can't be executed, print 
"no previous URLs". The input ends with the "Home" command, and then you simply have to stop the program. <-

Examples:

Input 1:
forward
https//softuni.bg/
https//softuni.bg/trainings/courses
back
forward
https//softuni.bg/trainings/2056
back
forward
forward
https//softuni.bg/trainings/courses
Home

Output 1:
no next URLs
https//softuni.bg/
https//softuni.bg/trainings/courses
https//softuni.bg/
https//softuni.bg/trainings/courses
https//softuni.bg/trainings/2056
https//softuni.bg/trainings/courses
https//softuni.bg/trainings/2056
no next URLs
https//softuni.bg/trainings/courses

Input 2:
back
https//google.bg/
https//google.bg/softuni
back
forward
https//google.bg/java/advanced
back
forward
https//google.bg/java/oop
back
https//google.bg/java/oop
Home

Output 2:
no previous URLs
https//google.bg/
https//google.bg/softuni
https//google.bg/
https//google.bg/softuni
https//google.bg/java/advanced
https//google.bg/softuni
https//google.bg/java/advanced
https//google.bg/java/oop
https//google.bg/java/advanced
https//google.bg/java/oop