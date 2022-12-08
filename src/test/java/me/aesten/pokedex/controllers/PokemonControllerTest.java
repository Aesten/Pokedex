package me.aesten.pokedex.controllers;

import me.aesten.pokedex.models.PokemonBasic;
import me.aesten.pokedex.models.PokemonDescribed;
import me.aesten.pokedex.services.PokemonFetcher;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class PokemonControllerTest {
    @Test
    public void getPokemon() {
        PokemonController controller = new PokemonController();
        PokemonFetcherMock pokemonFetcher = new PokemonFetcherMock();
        PokemonBasic pokemon = null;

        try {
            pokemon = controller.map(pokemonFetcher);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Assert.assertTrue(pokemon instanceof PokemonDescribed);
        PokemonDescribed advancedPokemon = (PokemonDescribed) pokemon;

        Assert.assertEquals(2, pokemon.getId());
        Assert.assertEquals("Poketest", pokemon.getName());
        Assert.assertEquals(Optional.of(22).get(), pokemon.getHeight());
        Assert.assertEquals(Optional.of(33).get(), pokemon.getWeight());
        Assert.assertEquals("Poketest description", advancedPokemon.getDescription());

    }

    static class PokemonFetcherMock implements PokemonFetcher {

        @Override
        public Map<String, Object> getAsMap() {
            Map<String, Object> pokemonData = new HashMap<>();
            pokemonData.put("id", 2);
            pokemonData.put("name", "Poketest");
            pokemonData.put("height", 22);
            pokemonData.put("weight", 33);
            pokemonData.put("description", "Poketest description");
            return pokemonData;
        }
    }
}
