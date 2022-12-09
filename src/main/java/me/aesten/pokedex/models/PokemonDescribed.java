package me.aesten.pokedex.models;

/**
 * A Pokemon class which inherits from PokemonBasic with an additional description field.
 */
public class PokemonDescribed extends PokemonBasic{
    private String description;
    public PokemonDescribed(int id, String name, Integer weight, Integer height, String description) {
        super(id, name, weight, height);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
