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
        //Instantiate the controller
        PokemonController controller = new PokemonController();
        //Creates a mock service that fetches a Pokemon
        PokemonFetcherMock pokemonFetcher = new PokemonFetcherMock();
        PokemonBasic pokemon = null;

        //Use the controller to map the Pokemon
        try {
            pokemon = controller.map(pokemonFetcher);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //The mock contains a description, so we check if the returned instance is a PokemonDescribed
        Assert.assertTrue(pokemon instanceof PokemonDescribed);
        PokemonDescribed advancedPokemon = (PokemonDescribed) pokemon;

        //Verify the data of the Pokemon instance
        Assert.assertEquals(2, pokemon.getId());
        Assert.assertEquals("Poketest", pokemon.getName());
        Assert.assertEquals(Optional.of(22).get(), pokemon.getHeight());
        Assert.assertEquals(Optional.of(33).get(), pokemon.getWeight());
        Assert.assertEquals("Poketest description", advancedPokemon.getDescription());

    }

    static class PokemonFetcherMock implements PokemonFetcher {
        //A mock implementation of PokemonFetcher with virtual data
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
