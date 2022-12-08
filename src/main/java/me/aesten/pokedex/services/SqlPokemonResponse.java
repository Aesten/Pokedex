package me.aesten.pokedex.services;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class SqlPokemonResponse implements PokemonFetcher {
    private final ResultSet response;

    public SqlPokemonResponse(ResultSet response) {
        this.response = response;
    }

    public static SqlPokemonResponse run(SqlPokemonRequest request) {
        try {
            // db parameters
            String url = "jdbc:sqlite:./src/main/resources/" + request.getDatabaseFileName();
            // create a connection to the database
            Connection conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");

            PreparedStatement stmt = conn.prepareStatement(request.getSqlRequest());
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return new SqlPokemonResponse(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
