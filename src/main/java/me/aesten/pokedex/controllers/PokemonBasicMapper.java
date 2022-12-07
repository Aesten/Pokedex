package me.aesten.pokedex.controllers;

import me.aesten.pokedex.models.PokemonBasic;
import me.aesten.pokedex.services.PokemonMap;

import java.util.Map;

public class PokemonBasicMapper {
    public PokemonBasic map(PokemonMap pokemonMap) {
        Map<String, Object> dataMap = pokemonMap.getAsMap();
        String name = (String) dataMap.get("name");
        Integer weight = (Integer) dataMap.get("weight");
        Integer height = (Integer) dataMap.get("height");
        return new PokemonBasic(name, weight, height);
    }
}
