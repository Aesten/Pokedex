package me.aesten.pokedex.services;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class SqlPokemonResponse implements PokemonMap{
    private final ResultSet response;

    public SqlPokemonResponse(ResultSet response) {
        this.response = response;
    }

    @Override
    public Map<String, Object> getAsMap() {
        try {
            ResultSetMetaData meta = response.getMetaData();
            int columns = meta.getColumnCount();
            Map<String, Object> mappedResponse = new HashMap<>();
            for(int i=1; i<=columns; ++i) {
                mappedResponse.put(meta.getColumnName(i),response.getObject(i));
            }
            return mappedResponse;
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
