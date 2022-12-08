package me.aesten.pokedex.views;

import me.aesten.pokedex.models.PokemonDescribed;

public class PokemonDescribedVisualizer extends PokemonBasicVisualizer{
    private final String description;

    public PokemonDescribedVisualizer(PokemonDescribed pokemon) {
        super(pokemon);
        this.description = pokemon.getDescription();
    }

    /**
     * Returns the information of the PokemonDescribed.
     * Method implementation from the Logger interface.
     *
     * @return a String describing the PokemonDescribed
     */
    @Override
    public String log() {
        return super.log() +
                "\ndescription: " + description;
    }

    /**
     * Returns the information of the PokemonDescribed with html formatting.
     * Method implementation from the HtmlLogger interface.
     *
     * @return a String describing the PokemonDescribed with html formatting
     */
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
