9. *Population Counter
So many people! It's hard to count them all. But that's your job as a statistician. You get raw data for a given city, and you need to aggregate it. 
On each input line, you'll be given data in the format: "city|country|population". There will be no redundant whitespaces anywhere in the input. Aggregate the data by country and by city and print it on the console. For each country, print its total population and on separate lines the data for each of its cities. Countries should be ordered by their total population in descending order, and within each country, the cities should be ordered by the same criterion. If two countries/cities have the same population, keep them in the order in which they were entered. Check out the examples. Follow the output format strictly!

Input
The input data should be read from the console.
It consists of a variable number of lines and ends when the command "report" is received.
The input data will always be valid and in the format described. There is no need to check it explicitly.

Output
The output should be printed on the console.
Print the aggregated data for each country and city in the format shown below.

Constraints
The name of the city, country, and population count will be separated from each other by a pipe ("|").
The number of input lines will be in the range [2 .... 50].
A city-country pair will not be repeated.
The population count of each city will be an integer in the range [0 .... 2 000 000 000].
Time limit: 100ms/16MB.

Examples:

Input 1:
Sofia|Bulgaria|1000000
report

Output 1:
Bulgaria (total population: 1000000)
=>Sofia: 1000000

Input 2:
Sofia|Bulgaria|1
Veliko Tarnovo|Bulgaria|2
London|UK|4
Rome|Italy|3
report

Output 2:
UK (total population: 4)
=>London: 4
Bulgaria (total population: 3)
=>Veliko Tarnovo: 2
=>Sofia: 1
Italy (total population: 3)
=>Rome: 3