1. Energy Drinks
Your friend Stamat is working on a new AI program. Like every irresponsible teenager, he programs all night and, of course, drinks a lot of energy drinks. Stamat's friends are concerned about him and want you to create a program
that tells him when to stop the energy drinks and start drinking water.
On the first line, you will receive a sequence of numbers representing milligrams of caffeine. On the second line, you will receive another sequence of numbers representing energy drinks. It is important to know that the maximum caffeine Stamat can have for the night is 300 milligrams, and his initial is always 0.
To calculate the caffeine in the drink take the last milligrams of caffeine and the first energy drink, and multiply them.
Then, compare the result with the caffeine Stamat drank:
If the sum of the caffeine in the drink and the caffeine that Stamat drank doesn't exceed 300 milligrams, remove both the milligrams of caffeine and the drink from their sequences. Also, add the caffeine to
Stamat's total caffeine. 
If Stamat is about to exceed his maximum caffeine per night, do not add the caffeine to Stamat's total caffeine. Remove the milligrams of caffeine and move the drink to the end of the sequence. Also, reduce the current caffeine that Stamat has taken by 30 (Note: Stamat's caffeine cannot go below 0).
Stop calculating when you are out of drinks or milligrams of caffeine.
For more clarification, see the examples below.

Input
In the first line, you will be given a sequence of the milligrams of caffeine - integers separated by comma and space ", " in the range [1, 50].
In the second line, you will be given a sequence of energy drinks - integers separated by comma and space ", " in the range [1, 300].

Output
On the first line:
If Stamat hasn't drunk all the energy drinks, print the remaining ones separated by a comma and a space ", ": 
"Drinks left: { remaining drinks separated by ", " }"
If Stamat has drunk all the energy drinks, print:
"At least Stamat wasn't exceeding the maximum caffeine."
On the next line, print:
"Stamat is going to sleep with { current caffeine } mg caffeine."

Constraints 
You will always have at least one element in each sequence at the beginning. 

Examples:

Input 1:
34, 2, 3
40, 100, 250

Output 1:
Drinks left: 100, 250
Stamat is going to sleep with 60 mg caffeine.

Comment 1:
1) Take the last milligrams of caffeine (3) and multiply them by the first energy drink (40). The result(120) doesn't exceed the caffeine limit per day (300), so we can add it to Stamat's caffeine.
Remove both items from their sequences. Stamat can accept 180 miligrams of caffeine more.
2) Take the next mg of caffeine (2) and multiply them by the next energy drink (100). The result is 200 and if he takes the drink, he will exceed the caffeine limit per day. We remove the mg of caffeine (2) and place the drink (100) at the end of the sequence ("250, 100").
Then, decrease Stamat's caffeine by 30 (Stamat's caffeine becomes 90). 
Stamat can accept 210 miligrams of caffeine more.
3) Take the next mg of caffeine (34) and multiply them by the next energy drink (250). The result(8500) is above 210,so we remove the mg of caffeine (34) and place the drink (250) at the end of the sequence ("100, 250").
Then, decrease Stamat's caffeine by 30 (Stamat's caffeine becomes 60).
4) Stamat slept with 60 mg of caffeine.

Input 2:
1, 16, 8, 14, 5
27, 23

Output 2:
At least Stamat wasn't exceeding the maximum caffeine.
Stamat is going to sleep with 289 mg caffeine.

Input 3:
1, 23, 2, 1, 42, 22, 7, 14
51, 100, 3, 7

Output 3:
At least Stamat wasn't exceeding the maximum caffeine.
Stamat is going to sleep with 264 mg caffeine.



Energy drinks don't give wingssss... (AI-generated text)

