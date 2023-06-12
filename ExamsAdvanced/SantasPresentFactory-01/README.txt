1. Santa's Present Factory 
Link: https://judge.softuni.org/Contests/Practice/Index/1983#0

Christmas is just around the corner and this year Santa has decided to share his secret with you. Get ready to learn how his dwarf's craft all the presents.  
First, you will receive a sequence of integers, representing the number of materials for crafting toys in one box. After that, you will be given another sequence of integers - their magic level. 
Your task is to mix materials with magic, so you can craft presents, listed in the table below with the exact magic level.
 
Present 	      Magic needed
Doll 		      150
Wooden train 	  250
Teddy bear 	      300
Bicycle  	      400

To craft a toy, you have to take the last box with materials and the first magic level value. The total magic level is calculated by their multiplication. If the result equals one of the levels described in the table above, you craft the present and remove both materials and magic value. Otherwise: 
If the product of the operation is a negative number, then you have to sum the values together, remove them both from their positions and the result should be added to the materials. 
If the product doesn't equal one of the magic levels in the table and is a positive number, remove only the magic value and increase the material value by 15.
If the magic or material (or both) equals 0, remove it (or both) and continue crafting the presents. 
Stop crafting presents when you run out of boxes of materials or magic level values.
Your task is considered done if you manage to craft either one of the pairs - a doll and a train or a teddy bear and a bicycle.

Input 
The first line of input will represent the values of boxes with materials - integers, separated by a single space. 
On the second line, you will be given the magic values - integers again, separated by a single space. 

Output 
On the first line - print whether you've succeeded in crafting the presents 
"The presents are crafted! Merry Christmas!"
"No presents this Christmas!"

On the next two lines print the materials and magic that are left, if there are any, otherwise skip the line 
"Materials left: {material1}, {material2}, ..."
"Magic left: {magicValue1}, {magicValue2}, ...
On the next lines print the presents you have crafted at least once, ordered alphabetically in the format: 
"{toy name}: {amount}" 
...

Constraints 
All the materials' values will be integers in the range [0, 100].
Magic level values will be integers in the range [-15, 100]. 
In all cases, at least one present will be crafted.

Examples:

Input 1:
10 -5 20 15 -30 10 
40 60 10 4 10 0 

Output 1:
The presents are crafted! Merry Christmas! 
Materials left: 20, -5, 10 
Bicycle: 1 
Teddy bear: 2

Comment 1:
First, we have 40*10 = 400 which is the needed magic for a bicycle. Remove both. 
60*(-30) = -1800 (negative).
60+(-30) = 30.
Remove 60 and -30. Add 30 to materials. 
30*10 = 300 (bear). Remove both. 
4*15 = 60, so remove 4 and the material is increased by 15 (15+15 = 30). 
10*30 = 300 (bear). 
Print desired text. 

Input 2:
30 5 15 60 0 30 
-15 10 5 -15 25

Output 2:
No presents this Christmas! 
Materials left: 20, 30 
Doll: 1 
Teddy bear: 1