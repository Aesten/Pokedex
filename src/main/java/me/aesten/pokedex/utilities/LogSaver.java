package me.aesten.pokedex.utilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LogSaver {
    public static void saveLog(String filePath, HtmlLogger htmlLogger) {
        try {
            Files.writeString(Paths.get(filePath), htmlLogger.logHtml());
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
