package me.aesten.pokedex.controllers;

import me.aesten.pokedex.models.PokemonBasic;
import me.aesten.pokedex.models.PokemonDescribed;
import me.aesten.pokedex.services.PokemonFetcher;

import java.util.Map;

public class PokemonController {
    /**
     * Maps a PokemonFetcher to a Pokemon.
     * The returned instance can be a PokemonBasic or PokemonDescribed depending on whether
     * there is a description or not.
     *
     * @param pokemonFetcher an implementation of the PokemonFetcher interface
     * @return the Pokemon instance identified from the fetcher
     */
    public PokemonBasic map(PokemonFetcher pokemonFetcher) {
        Map<String, Object> dataMap = pokemonFetcher.getAsMap();
        Integer id = (Integer) dataMap.get("id");
        String name = (String) dataMap.get("name");
        String description = (String) dataMap.get("description");
        Integer weight = (Integer) dataMap.get("weight");
        Integer height = (Integer) dataMap.get("height");
        //return a PokemonDescribed if the description exists, a PokemonBasic otherwise
        return description != null ? new PokemonDescribed(id, name, weight, height, description) : new PokemonBasic(id, name, weight, height);
    }
}
