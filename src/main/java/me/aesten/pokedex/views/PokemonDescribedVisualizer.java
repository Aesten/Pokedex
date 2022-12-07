package me.aesten.pokedex.views;

import me.aesten.pokedex.models.PokemonDescribed;

public class PokemonDescribedVisualizer extends PokemonBasicVisualizer{
    private final String description;

    public PokemonDescribedVisualizer(PokemonDescribed pokemon) {
        super(pokemon);
        this.description = pokemon.getDescription();
    }

    @Override
    public String log() {
        return super.log() +
                "\ndescription: " + description;
    }

    @Override
    public String logHtml() {
        return "<h1>" + name + "</h1>" +
                "\n<ul>" +
                "\n\t<li>" + "id: " + id + "</li>" +
                "\n\t<li>" + "height: " + height + "</li>" +
                "\n\t<li>" + "weight: " + weight + "</li>" +
                "\n\t<li>" + "description: " + description + "</li>" +
                "\n</ul>";
    }
}
