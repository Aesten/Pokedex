

# Build the project

```bash
./gradlew build
```

# Run the application

```bash
./gradlew run
```

To run the application with command line arguments :

```bash
./gradlew run --args="premierArgument secondArgument"
```

The html log files should appear with a new 'output' directory.

# Run the tests

```bash
./gradlew test
```

# Run as a jar

You can build the project to run the application.
In that case you need the sqlite database in the same folder as the jar.
You can then use:

```bash
java -jar <build>.jar <id> <database>
```

Without the database, only the online API access will work.
