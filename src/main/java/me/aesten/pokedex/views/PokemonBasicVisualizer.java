package me.aesten.pokedex.views;

import me.aesten.pokedex.models.PokemonBasic;

public class PokemonBasicVisualizer {
    protected final String name;
    protected final Integer weight;
    protected final Integer height;

    public PokemonBasicVisualizer(PokemonBasic pokemon) {
        this.name = pokemon.getName();
        this.weight = pokemon.getWeight();
        this.height = pokemon.getHeight();
    }

    public void print() {
        System.out.println("name: " + name);
        System.out.println("weight: " + weight);
        System.out.println("height: " + height);
    }
}
