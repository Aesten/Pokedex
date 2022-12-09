package me.aesten.pokedex.services;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

/**
 * A service to send a sql request to fetch a Pokemon.
 * Implements PokemonFetcher.
 */
public class SqlPokemonResponse implements PokemonFetcher {
    private final ResultSet response;

    public SqlPokemonResponse(ResultSet response) {
        this.response = response;
    }

    /**
     * Runs the SqlPokemonRequest to fetch a Pokemon from a database.
     * The corresponding SqlPokemonResponse is returned.
     *
     * @param request the SqlPokemonRequest for fetching the Pokemon
     * @return the corresponding SqlPokemonResponse
     */
    public static SqlPokemonResponse run(SqlPokemonRequest request) {
        try {
            // database parameters
            String url = "jdbc:sqlite:./" + request.getDatabaseFileName();
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

    /**
     * Converts the received sql data to a java Map object.
     * Implementation of a method in the Pokemon Fetcher interface.
     *
     * @return a Map&lt;java.lang.String, java.lang.Object&gt; containing fetched information
     */
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
