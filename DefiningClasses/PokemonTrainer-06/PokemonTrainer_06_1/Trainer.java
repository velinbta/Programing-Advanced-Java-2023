package PokemonTrainer_06_1;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String name;
    private int badges;
    private List<Pokemon> pokemonCollection;

    public Trainer(String name) {
        this.name = name;
        pokemonCollection = new ArrayList<>();
    }

    public boolean containsAtLeastOnePokemonWithGivenElement(String element) {
        return this.pokemonCollection.stream().anyMatch(pokemon -> pokemon.getElement().equals(element));
    }

    public void decreasePokemonsHealthBy10AndRemoveIfBelow1() {
        this.pokemonCollection.forEach(Pokemon::decreaseHealthBy10);
        this.pokemonCollection.removeIf(pokemon -> pokemon.getHealth() < 1);
    }

    public void increaseBadges() {
        this.badges++;
    }

    public String getName() {
        return this.name;
    }

    public int getBadges() {
        return this.badges;
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemonCollection.add(pokemon);
    }

    public int getPokemonCount() {
        return this.pokemonCollection.size();
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", getName(), getBadges(), getPokemonCount());
    }

}
