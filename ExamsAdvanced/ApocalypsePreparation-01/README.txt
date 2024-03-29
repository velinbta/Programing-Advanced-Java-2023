01. Apocalypse Preparation

You are in the middle of a zombie apocalypse, and you want to go out for exploration. But before you do that, you need to prepare some healing items.
On the first line, you will be given a sequence representing textiles. On the second line, you will be given another sequence, which represents medicaments. 
While both collections contain any elements, you will have to combine elements from the collections in order to create healing items. You should start by getting the first value of textile and the last value of medicaments:  

If their sum is equal to any of the items in the table below create that item and remove both values. 
Otherwise, check if the sum is bigger than the value of the MedKit, create the MedKit, remove both values, and add the remaining resources(of the sum) to the next value in the medicament collection (Take the element from the collection, add the remaining sum to it, and put the element back to its place).
If you can't create anything, remove the textile value, add 10 to the medicament value, and return the medicament back to its place, into its collection.
You need to stop creating healing items when either the textile or the medicaments are exhausted. 

Healing item         Resources needed
Patch			             30
Bandage			             40
MedKit			             100

In the end, you should print on the console message for the sequence that has ended, then the created items, and in the end the remaining items (if any).

Input 
On the first line, you will receive a sequence of integers representing the textiles, separated by a single space (" ").
On the second line, you will receive a sequence of integers representing the medicaments, separated by a single space (" ").

Output 
On the first line, print which one of the collections is over:
If the textile is over print: "Textiles are empty."
If the medicaments are over print: "Medicaments are empty."
If both are empty print: "Textiles and medicaments are both empty." 

On the next n lines print only the created items (if any) ordered by the amount created descending, then by name alphabetically:
"{item name} - {amount created}
 {item name} - {amount created}
..."

Hint: Do not print items, which are not created.
On the last line print the remaining items (if any):
If there are any medicaments left: 
"Medicaments left: {medicament1}, {medicament2}..."
If there are any textiles left:  
"Textiles left: {textile1}, {textile2}..."

Constraints 
All the numbers will be in the range [0...1000].
All the inputs will be valid.

Examples:

Input 1:
20 10 40 70 20
50 10 30 20 80

Output 1:
Textiles are empty.
MedKit - 2
Bandage - 1
Patch - 1
Medicaments left: 50

Comment 1:
We start by taking the first textile (20) and the last medicament (80) the sum is 100 so you create one MedKit.
Then you take textile (10) and medicament (20) the sum is 30 and you create one Patch.
The third time you take textile (40) and medicament (30) the sum is 70 it's not on the table. So you add 10 to the medicaments and insert them back.
Next, you take textile (70) and medicaments (40) keep in mind that you get the medicaments from the previous operation. The sum is 110 so you create one MedKit. The MedKit will take only 100 of the resources, so you add the remaining resources (10) to the next element in the medicament sequence. 
Next, you get textile (20) and medicaments (10 + 10) the sum is 40 so you create one Bandage.
Textiles are empty so the program ends. You have managed to create one Bandage, two MedKits, and one Patch.

Input 2:
30 30 10 80 60
40 20 30 10 70

Output 2:
Textiles and medicaments are both empty.
MedKit - 3
Bandage - 2

Input 3:
30 30 10 80 60 20
40 20 30 10 70

Output 3:
Medicaments are empty.
MedKit - 3
Bandage - 2
Textiles left: 20

Input 4:
60 15 20 30 20
20 15 40

Output 4:
Medicaments are empty.
Bandage - 1
MedKit - 1
Patch - 1
Textiles left: 30, 20