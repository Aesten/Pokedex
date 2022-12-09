package me.aesten.pokedex.views;

import me.aesten.pokedex.models.PokemonDescribed;

/**
 * A view for PokemonDescribed which has the additional 'description' field
 */
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
        String partialLog = super.logHtml();
        return partialLog.substring(0, partialLog.length()-6) +
                "\n\t<li>" + "description: " + description + "</li>" +
                "\n</ul>";
    }
}
