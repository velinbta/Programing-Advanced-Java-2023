11. *Legendary Farming
You've beaten all the content, and the last thing left to accomplish is to own a legendary item. However, it's a tedious process and requires quite a bit of farming. Anyway, you are not too pretentious - any legendary will do. The possible items are:

Shadowmourne - requires 250 Shards;
Valanyr - requires 250 Fragments;
Dragonwrath - requires 250 Motes;

Shards, Fragments, and Motes are the key materials, all else is junk. You will be given lines of input, such as 
2 motes 3 ores 15 stones. Keep track of the key materials - the first that reaches the 250 mark wins the race. At that point, print the corresponding legendary obtained. Then, print the remaining shards, fragments, and motes, ordered by quantity in descending order, each on a new line. Finally, print the collected junk items in alphabetical order.

Input
Each line of input is in format "{quantity} {material} {quantity} {material} .... {quantity} {material}".

Output
On the first line, print the obtained item in the format "{Legendary item} obtained!".
On the next three lines, print the remaining key materials in descending order by quantity.
If two key materials have the same quantity, print them in alphabetical order.
On the final several lines, print the junk items in alphabetical order.
All materials are printed in format "{material}: {quantity}".
All output should be lowercase, except the first letter of the legendary.

Constraints
The quantity-material pairs are between 1 and 25 per line.
The number of lines is in the range [1..10].
All materials are case-insensitive.
Allowed time: 250ms/16MB.

Examples:

Input 1:
3 Motes 5 stones 5 Shards
6 leathers 255 fragments 7 Shards

Output 1:
Valanyr obtained!
fragments: 5
shards: 5
motes: 3
leathers: 6
stones: 5

Input 2:
123 silver 6 shards 8 shards 5 motes
9 fangs 75 motes 103 MOTES 8 Shards
86 Motes 7 stones 19 silver

Output 2:
Dragonwrath obtained!
shards: 22
motes: 19
fragments: 0
fangs: 9
silver: 123