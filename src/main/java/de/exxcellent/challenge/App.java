package de.exxcellent.challenge;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as
 * baseline for your software design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */


public final class App {


  /**
   * Argument parser for parsing inputs using key value parse like this: args= ["--football",
   * "football.csv", "--weather", "weather.csv"] returns into a HashMap containing {"football":
   * "football.csv", "weather", "weather.csv"}
   *
   * @param args a string array containing key value pairs
   * @return a HashMap with the key value pairs
   */

  public static Map<String, String> parseArguments(String[] args) {
    Map<String, String> parsedArguments = new HashMap<>();
    String currentKey = null;

    for (int i = 0; i < args.length; i++) {
      String arg = args[i].trim();

      if (arg.startsWith("--")) {
        // Remove the leading "--" to get the argument key
        currentKey = arg.substring(2).trim();
      } else if (currentKey != null) {
        // Store the argument value with the current key
        parsedArguments.put(currentKey, arg);
        currentKey = null; // Reset the key
      }
    }

    return parsedArguments;
  }

    /**
     * returns the day with the smallest distance between min and max temperatur
     * @param path path for the csv file
     * @return the day with the smallest difference
     */
  public static String getSmallestDifferenceDay(String path) {
    IReader reader = null;
    try {
      reader = new CsvReader(path);
      String indexName = "Day";
      String[] relevantColumns = {"MxT", "MnT"};

      return DatasetAnalyzer.getValueWithSmallestDistance(
          reader, indexName,
          relevantColumns);

    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public static String getSmallestDifferenceTeam(String path) {
    IReader reader = null;
    try {
      reader = new CsvReader(path);
      String indexName = "Team";
      String[] relevantColumns = {"Goals", "Goals Allowed"};

      return DatasetAnalyzer.getValueWithSmallestDistance(
          reader, indexName,
          relevantColumns);

    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * This is the main entry method of your program.
   *
   * @param args The CLI arguments passed
   */
  public static void main(String... args) {

    // Parse the arguments
    Map<String, String> parsedArguments = parseArguments(args);
    // Access the parsed arguments
    final String footballPath = parsedArguments.get("football");
    final String weatherPath = parsedArguments.get("weather");

    if (weatherPath != null) {
      String dayWithSmallestTempSpread = getSmallestDifferenceDay(weatherPath);
      System.out.printf("Day with smallest temperature spread : %s%n",
          dayWithSmallestTempSpread);
    }

    if (footballPath != null) {
      String teamWithSmallestGoalSpread = getSmallestDifferenceTeam(footballPath);
      System.out.printf("Team with smallest goal spread       : %s%n",
          teamWithSmallestGoalSpread);
    }


  }

  // Your day analysis function call …

}
