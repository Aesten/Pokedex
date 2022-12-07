package me.aesten.pokedex.services;

import java.sql.*;

public class SqlPokemonRequest {
    private Integer requestPokemonId;
    private String databaseFileName;
    private String request;

    public static SqlPokemonRequest create() {
        return new SqlPokemonRequest(1, "pokemondatabase.sqlite");
    }

    private SqlPokemonRequest(int requestPokemonId, String databaseFileName) {
        this.requestPokemonId = requestPokemonId;
        this.databaseFileName = databaseFileName;
    }

    public SqlPokemonRequest setRequestPokemonId(int id) {
        requestPokemonId = id;
        return this;
    }

    public SqlPokemonRequest setRequestDatabase(String databaseFileName) {
        this.databaseFileName = databaseFileName;
        return this;
    }

    public SqlPokemonRequest build() {
        request = "SELECT * FROM pokemons WHERE id = " + requestPokemonId;
        return this;
    }

    public SqlPokemonResponse run() {
        try {
            // db parameters
            String url = "jdbc:sqlite:./src/main/resources/" + databaseFileName;
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
