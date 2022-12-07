package me.aesten.pokedex.views;

import me.aesten.pokedex.models.PokemonDescribed;

public class PokemonDescribedVisualizer extends PokemonBasicVisualizer{
    private final String description;

    public PokemonDescribedVisualizer(PokemonDescribed pokemon) {
        super(pokemon);
        this.description = pokemon.getDescription();
    }

    public void print() {
        System.out.println("name: " + name);
        System.out.println("description: " + description);
        System.out.println("weight: " + weight);
        System.out.println("height: " + height);
    }
}
