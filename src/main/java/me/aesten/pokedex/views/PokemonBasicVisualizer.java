package me.aesten.pokedex.views;

import me.aesten.pokedex.models.PokemonBasic;
import me.aesten.pokedex.utilities.HtmlLogger;
import me.aesten.pokedex.utilities.Logger;

public class PokemonBasicVisualizer implements Logger, HtmlLogger {
    protected final int id;
    protected final String name;
    protected final Integer weight;
    protected final Integer height;

    public PokemonBasicVisualizer(PokemonBasic pokemon) {
        this.id = pokemon.getId();
        this.name = pokemon.getName();
        this.weight = pokemon.getWeight();
        this.height = pokemon.getHeight();
    }

    @Override
    public String log() {
        return "name: " + name +
                "\nid: " + id +
                "\nweight: " + weight +
                "\nheight: " + height;
    }

    @Override
    public String logHtml() {
        return "<h1>" + name + "</h1>" +
                "\n<ul>" +
                "\n\t<li>" + "id: " + id + "</li>" +
                "\n\t<li>" + "height: " + height + "</li>" +
                "\n\t<li>" + "weight: " + weight + "</li>" +
                "\n</ul>";
    }


}
