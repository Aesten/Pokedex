package me.aesten.pokedex;


import me.aesten.pokedex.controllers.PokemonBasicMapper;
import me.aesten.pokedex.controllers.PokemonDescribedMapper;
import me.aesten.pokedex.models.PokemonBasic;
import me.aesten.pokedex.models.PokemonDescribed;
import me.aesten.pokedex.services.HttpPokemonRequest;
import me.aesten.pokedex.services.HttpPokemonResponse;
import me.aesten.pokedex.services.SqlPokemonRequest;
import me.aesten.pokedex.services.SqlPokemonResponse;
import me.aesten.pokedex.views.PokemonBasicVisualizer;
import me.aesten.pokedex.views.PokemonDescribedVisualizer;

public class Pokedex {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("You haven't provided any argument!");
            System.exit(0);
        }

        else if (args.length == 1) {
            int id = Integer.parseInt(args[0]);

            HttpPokemonRequest httpRequest = HttpPokemonRequest.create().setRequestPokemonId(id).build();
            HttpPokemonResponse httpResponse = httpRequest.run();
            PokemonBasicMapper mapper = new PokemonBasicMapper();
            PokemonBasic pokemon = mapper.map(httpResponse);
            PokemonBasicVisualizer visualizer = new PokemonBasicVisualizer(pokemon);

            System.out.println("===================");
            visualizer.print();
            System.out.println("===================");
        }

        else if (args.length == 2) {
            int id = Integer.parseInt(args[0]);
            String database = args[1];

            SqlPokemonRequest sqlRequest = SqlPokemonRequest.create().setRequestPokemonId(id).setRequestDatabase(database).build();
            SqlPokemonResponse sqlResponse = sqlRequest.run();
            PokemonDescribedMapper mapper = new PokemonDescribedMapper();
            PokemonDescribed pokemon = mapper.map(sqlResponse);
            PokemonDescribedVisualizer visualizer = new PokemonDescribedVisualizer(pokemon);

            System.out.println("===================");
            visualizer.print();
            System.out.println("===================");
        }

        else {
            System.err.println("Too many arguments!");
            System.exit(0);
        }
    }

    public String getName() {
        return "Pokedex";
    }
}
