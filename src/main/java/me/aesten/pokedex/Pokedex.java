package me.aesten.pokedex;


import me.aesten.pokedex.controllers.PokemonController;
import me.aesten.pokedex.models.PokemonBasic;
import me.aesten.pokedex.models.PokemonDescribed;
import me.aesten.pokedex.services.HttpPokemonRequest;
import me.aesten.pokedex.services.HttpPokemonResponse;
import me.aesten.pokedex.services.SqlPokemonRequest;
import me.aesten.pokedex.services.SqlPokemonResponse;
import me.aesten.pokedex.utilities.ConsoleLogUtility;
import me.aesten.pokedex.utilities.FileLogUtility;
import me.aesten.pokedex.views.PokemonBasicVisualizer;
import me.aesten.pokedex.views.PokemonDescribedVisualizer;

import java.io.File;

public class Pokedex {
    public static void main(String[] args) {
        String gradleBuildPath = "." + File.separator + "build" + File.separator + "libs";
        if (args.length == 0) {
            System.err.println("You haven't provided any argument!");
            System.exit(0);
        }

        else if (args.length == 1) {
            int id = Integer.parseInt(args[0]);

            HttpPokemonRequest httpRequest = HttpPokemonRequest.builder().setRequestPokemonId(id).build();
            HttpPokemonResponse httpResponse = HttpPokemonResponse.run(httpRequest);
            PokemonController controller = new PokemonController();
            PokemonBasic pokemon = controller.map(httpResponse);
            PokemonBasicVisualizer visualizer = new PokemonBasicVisualizer(pokemon);

            System.out.println("===================");
            ConsoleLogUtility.log(visualizer);
            System.out.println("===================");

            FileLogUtility.saveLog(gradleBuildPath + File.separator + "basic" + id + ".html", visualizer);
        }

        else if (args.length == 2) {
            int id = Integer.parseInt(args[0]);
            String database = args[1];

            SqlPokemonRequest sqlRequest = SqlPokemonRequest.builder().setRequestPokemonId(id).setRequestDatabase(database).build();
            SqlPokemonResponse sqlResponse = SqlPokemonResponse.run(sqlRequest);
            PokemonController controller = new PokemonController();
            PokemonDescribed pokemon = (PokemonDescribed) controller.map(sqlResponse);
            PokemonDescribedVisualizer visualizer = new PokemonDescribedVisualizer(pokemon);

            System.out.println("===================");
            ConsoleLogUtility.log(visualizer);
            System.out.println("===================");

            FileLogUtility.saveLog(gradleBuildPath + File.separator + "described" + id + ".html", visualizer);
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
