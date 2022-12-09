package me.aesten.pokedex.services;

/**
 * A service which allows to generate an sql request.
 * It has to be passed to SqlPokemonResponse to be used.
 */
public class SqlPokemonRequest {
    private final String databaseFileName;
    private final String SqlRequest;

    private SqlPokemonRequest(String databaseFileName, String SqlRequest) {
        this.databaseFileName = databaseFileName;
        this.SqlRequest = SqlRequest;
    }

    /**
     * Calls a SqlPokemonRequestBuilder. You cannot directly use the constructor for the SqlPokemonRequest.
     *
     * @return a SqlPokemonRequestBuilder
     */
    public static Builder builder() {
        return new Builder();
    }


    public String getDatabaseFileName() {
        return databaseFileName;
    }

    public String getSqlRequest() {
        return SqlRequest;
    }

    /**
     * The SqlPokemonRequestBuilder allows to prepare a sql request.
     */
    public static class Builder {
        private Integer requestPokemonId;
        private String databaseFileName;

        private Builder() {}

        public Builder setRequestPokemonId(int id) {
            requestPokemonId = id;
            return this;
        }

        public Builder setRequestDatabase(String databaseFileName) {
            this.databaseFileName = databaseFileName;
            return this;
        }

        public SqlPokemonRequest build() {
            String SqlRequest = "SELECT * FROM pokemons WHERE id = " + requestPokemonId;
            return new SqlPokemonRequest(databaseFileName, SqlRequest);
        }

    }
}
