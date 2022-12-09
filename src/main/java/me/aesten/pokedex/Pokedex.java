package me.aesten.pokedex;


import me.aesten.pokedex.controllers.PokemonController;
import me.aesten.pokedex.models.PokemonBasic;
import me.aesten.pokedex.models.PokemonDescribed;
import me.aesten.pokedex.services.HttpPokemonRequest;
import me.aesten.pokedex.services.HttpPokemonResponse;
import me.aesten.pokedex.services.SqlPokemonRequest;
import me.aesten.pokedex.services.SqlPokemonResponse;
import me.aesten.pokedex.utilities.ConsoleLogger;
import me.aesten.pokedex.utilities.LogSaver;
import me.aesten.pokedex.utilities.Logger;
import me.aesten.pokedex.views.PokemonBasicVisualizer;
import me.aesten.pokedex.views.PokemonDescribedVisualizer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Pokedex {
    public static void main(String[] args) {
        //Preparing the save path for the output log
        String savePath = System.getProperty("user.dir") + File.separator + "outputs";
        try {Files.createDirectories(Paths.get(savePath));}
        catch (IOException e) {throw new RuntimeException(e);}

        //Do stuff according to args length
        if (args.length == 0) {
            System.err.println("You haven't provided any argument!");
            System.exit(0);
        }

        //Case 1 argument: http request
        else if (args.length == 1) {
            int id;
            try{id = Integer.parseInt(args[0]);}
            catch (NumberFormatException e) {throw new RuntimeException(e);}

            //Request and map a Pokemon from the web
            HttpPokemonRequest httpRequest = HttpPokemonRequest.builder().setRequestPokemonId(id).build();
            HttpPokemonResponse httpResponse = HttpPokemonResponse.run(httpRequest);
            PokemonController controller = new PokemonController();
            PokemonBasic pokemon = controller.map(httpResponse);
            PokemonBasicVisualizer visualizer = new PokemonBasicVisualizer(pokemon);

            //Logging
            printLogs(visualizer);
            LogSaver.saveLog(savePath + File.separator + "basic-" + id + ".html", visualizer);
        }

        //Case 2 arguments: sql request
        else if (args.length == 2) {
            int id;
            try{id = Integer.parseInt(args[0]);}
            catch (NumberFormatException e) {throw new RuntimeException(e);}
            String database = args[1];

            //Request and map a Pokemon from the specified database
            SqlPokemonRequest sqlRequest = SqlPokemonRequest.builder().setRequestPokemonId(id).setRequestDatabase(database).build();
            SqlPokemonResponse sqlResponse = SqlPokemonResponse.run(sqlRequest);
            PokemonController controller = new PokemonController();
            PokemonDescribed pokemon = (PokemonDescribed) controller.map(sqlResponse);
            PokemonDescribedVisualizer visualizer = new PokemonDescribedVisualizer(pokemon);

            //Logging
            printLogs(visualizer);
            LogSaver.saveLog(savePath + File.separator + "described-" + id + ".html", visualizer);
        }

        else {
            System.err.println("Too many arguments!");
            System.exit(0);
        }
    }

    public String getName() {
        return "Pokedex";
    }

    private static void printLogs(Logger logger) {
        System.out.println("===================");
        ConsoleLogger.log(logger);
        System.out.println("===================");
    }
}
