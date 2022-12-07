package me.aesten.pokedex.controllers;

import me.aesten.pokedex.models.PokemonBasic;
import me.aesten.pokedex.models.PokemonDescribed;
import me.aesten.pokedex.services.PokemonMap;

import java.util.Map;

public class PokemonDescribedMapper {
    public PokemonDescribed map(PokemonMap pokemonMap) {
        Map<String, Object> dataMap = pokemonMap.getAsMap();
        String name = (String) dataMap.get("name");
        String description = (String) dataMap.get("description");
        Integer weight = (Integer) dataMap.get("weight");
        Integer height = (Integer) dataMap.get("height");
        return new PokemonDescribed(name, weight, height, description);
    }
}
