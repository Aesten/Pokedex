package me.aesten.pokedex.models;

public class PokemonDescribed extends PokemonBasic{
    private String description;
    public PokemonDescribed(String name, Integer weight, Integer height, String description) {
        super(name, weight, height);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
