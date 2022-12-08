package me.aesten.pokedex.controllers;

import me.aesten.pokedex.models.PokemonBasic;
import me.aesten.pokedex.models.PokemonDescribed;
import me.aesten.pokedex.services.PokemonFetcher;

import java.util.Map;

public class PokemonController {
    public PokemonBasic map(PokemonFetcher pokemonFetcher) {
        Map<String, Object> dataMap = pokemonFetcher.getAsMap();
        Integer id = (Integer) dataMap.get("id");
        String name = (String) dataMap.get("name");
        String description = (String) dataMap.get("description");
        Integer weight = (Integer) dataMap.get("weight");
        Integer height = (Integer) dataMap.get("height");
        if (description != null) {
            return new PokemonDescribed(id, name, weight, height, description);
        }
        else {
            return new PokemonBasic(id, name, weight, height);
        }
    }

}
