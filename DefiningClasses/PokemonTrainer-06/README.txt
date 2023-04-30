6. Pokemon Trainer
You want to be the best pokemon trainer, like no one ever was, so you set out to catch pokemon. Define a class Trainer and a class Pokemon. The trainer has a name, a number of badges, and a collection of pokemon. Pokemon has a name, an element, and health, all values are mandatory. Every Trainer starts with 0 badges.
From the console, you will receive an unknown number of lines until you receive the command "Tournament", each line will carry information about a pokemon and the trainer who caught it in the format "{TrainerName} {PokemonName} {PokemonElement} {PokemonHealth}" where TrainerName is the name of the Trainer who caught the pokemon, names are unique there cannot be 2 trainers with the same name. After receiving the command "Tournament" an unknown number of lines containing one of three elements "Fire", "Water", and "Electricity" will follow until the command "End" is received. For every command, you must check if a trainer has at least 1 pokemon with the given element, if he does he receive 1 badge, otherwise, all his pokemon lose 10 health, if a pokemon falls to 0 or less health, he dies and must be deleted from the trainer's collection. After the command "End" is received, you should print all trainers sorted by the amount of badges they have in descending order (if two trainers have the same amount of badges, they should be sorted by order of appearance in the input) in the format "{TrainerName} {Badges} {NumberOfPokemon}".

Examples:

Input 1:
Peter Charizard Fire 100
George Squirtle Water 38
Peter Pikachu Electricity 10
Tournament
Fire
Electricity
End

Output 1:
Peter 2 2
George 0 1

Input 2:
Sam Blastoise Water 18
Alex Pikachu Electricity 22
John Kadabra Psychic 90
Tournament
Fire
Electricity
Fire
End

Output 2:
Alex 1 1
Sam 0 0
John 0 1