package de.exxcellent.challenge;


import java.io.IOException;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */


public final class App {

    public static final String WEATHER_PATH = "de/exxcellent/challenge/weather.csv";
    public static final String FOOTBALL_PATH = "de/exxcellent/challenge/football.csv";

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {
        try {
            ICSVReader weatherReader = new CsvReader(WEATHER_PATH);
            ICSVReader goalReader = new CsvReader(FOOTBALL_PATH);


            String dayWithSmallestTempSpread = DatasetAnalyzer.getValueWithSmallestDistance(
                weatherReader, "Day",
                new String[]{"MxT", "MnT"});

            System.out.printf("Day with smallest temperature spread : %s%n",
                dayWithSmallestTempSpread);

            String teamWithSmallestGoalSpread = DatasetAnalyzer.getValueWithSmallestDistance(
                goalReader, "Team",
                new String[]{"Goals", "Goals Allowed"});
            System.out.printf("Team with smallest goal spread       : %s%n",
                teamWithSmallestGoalSpread);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


            // Your day analysis function call …

}
