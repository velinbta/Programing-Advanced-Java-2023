6. Product Shop
Write a program that prints information about food shops in Sofia and the products they store. Until the "Revision" command you will receive an input in the format: "{shop}, {product}, {price}".
Keep in mind that if you get a store that already exists, you must gather product information.

Your output must be ordered by shop name and must be in the format:
"{shop}->
Product: {product}, Price: {price}"
The price should be formatted to one digit after the decimal point.

Examples:

Input 1:
lidl, peach, 1.20
lidl, juice, 2.30
fantastico, apple, 1.20
kaufland, banana, 1.10
fantastico, grape, 2.20
Revision

Output 1:
fantastico->
Product: apple, Price: 1.2
Product: grape, Price: 2.2
kaufland->
Product: banana, Price: 1.1
lidl->
Product: peach, Price: 1.2
Product: juice, Price: 2.3

Input 2:
tmarket, peanuts, 2.20
GoGrill, meatballs, 3.30
GoGrill, HotDog, 1.40
tmarket, sweets, 2.20
Revision

Output 2:
GoGrill->
Product: meatballs, Price: 3.3
Product: HotDog, Price: 1.4
tmarket->
Product: peanuts, Price: 2.2
Product: sweets, Price: 2.2