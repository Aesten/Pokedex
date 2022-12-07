package me.aesten.pokedex.services;

import java.sql.*;

public class SqlPokemonRequest {
    private Integer requestPokemonId;
    private String request;

    public static SqlPokemonRequest create() {
        return new SqlPokemonRequest(1);
    }

    private SqlPokemonRequest(int requestPokemonId) {
        this.requestPokemonId = requestPokemonId;
    }

    public SqlPokemonRequest setRequestPokemonId(int id) {
        requestPokemonId = id;
        return this;
    }

    public SqlPokemonRequest build() {
        request = "SELECT * FROM pokemons WHERE id = " + requestPokemonId;
        return this;
    }

    public SqlPokemonResponse run() {
        try {
            // db parameters
            String url = "jdbc:sqlite:./src/main/resources/pokemondatabase.sqlite";
            // create a connection to the database
            Connection conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");

            PreparedStatement stmt = conn.prepareStatement(request);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return new SqlPokemonResponse(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
