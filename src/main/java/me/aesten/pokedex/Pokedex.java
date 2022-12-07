package me.aesten.pokedex;


import me.aesten.pokedex.controllers.PokemonMapper;
import me.aesten.pokedex.models.Pokemon;
import me.aesten.pokedex.services.HttpPokemonRequest;
import me.aesten.pokedex.services.HttpPokemonResponse;
import me.aesten.pokedex.services.SqlPokemonRequest;
import me.aesten.pokedex.services.SqlPokemonResponse;

public class Pokedex {
    public static void main(String[] args) {
        System.out.println("Java version " + System.getProperty("java.version"));
        System.out.println("It's working !");
        if (args.length > 0) {
            System.out.println("Vous avez fourni l'argument " + args[0]);
        }

        HttpPokemonRequest httpRequest = HttpPokemonRequest.create().setRequestPokemonId(1).build();
        HttpPokemonResponse httpResponse = httpRequest.run();
        SqlPokemonRequest sqlRequest = SqlPokemonRequest.create().setRequestPokemonId(1).build();
        SqlPokemonResponse sqlResponse = sqlRequest.run();

        PokemonMapper mapper = new PokemonMapper();
        Pokemon pokemon1 = mapper.map(httpResponse);
        Pokemon pokemon2 = mapper.map(sqlResponse);

        System.out.println(pokemon1.getName());
        System.out.println(pokemon2.getName());
    }

    public String getName() {
        return "Pokedex";
    }
}
