package de.exxcellent.challenge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Example JUnit 5 test case.
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
class AppTest {

    @Test
    void testFootball() {
        var football_path =  "football.csv";

        String expected = "Aston_Villa";

        String successLabel = App.getSmallestDifferenceTeam(football_path);
        assertEquals(expected, successLabel, "My expectations were not met");
    }

    @Test
    void testWeather() {
        var football_path =  "weather.csv";

        String expected = "14";

        String successLabel = App.getSmallestDifferenceDay(football_path);
        assertEquals(expected, successLabel, "My expectations were not met");
    }

    @Test
    void runFootball() {
        App.main("--football", "football.csv");
    }

    @Test
    void runWeather() {
        App.main("--weather", "weather.csv");
    }

    @Test
    void runBoth() {
        App.main("--football", "football.csv", "--weather", "weather.csv");
    }

}