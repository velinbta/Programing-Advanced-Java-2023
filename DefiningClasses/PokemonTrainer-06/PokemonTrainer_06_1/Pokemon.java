package PokemonTrainer_06_1;

public class Pokemon {
    private String pokemonName;
    private String element;
    private int health;

    public Pokemon(String pokemonName, String element, int health) {
        this.pokemonName = pokemonName;
        this.element = element;
        this.health = health;
    }

    public String getElement() {
        return this.element;
    }

    public int getHealth() {
        return this.health;
    }

    public void decreaseHealthBy10() {
        this.health -= 10;
    }

}
