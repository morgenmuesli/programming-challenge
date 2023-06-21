package de.exxcellent.challenge;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DatasetAnalyzerTest {



  @Test
  void getDistance() {
    double[] diff_values = {0.0, 2.0};
    String[] col_names = {"value_0", "value_1"};
    double expected_dis = 2.;

    HashMap<String, String> map= new HashMap<>();

    map.put("Day" , "20");
    for (int i = 0; i < diff_values.length; i++) {
      map.put(col_names[i], String.valueOf(diff_values[i]));
    }

    assertEquals(DatasetAnalyzer.getDistance(map, col_names), expected_dis, "wrong distance in different values");

    String neg_value = "-2";
    String neg_label = "neg_value";

    col_names[1] = neg_label;
    map.put(neg_label, neg_value);

    assertEquals(DatasetAnalyzer.getDistance(map, col_names), expected_dis, "wrong distance with negative values");

    col_names[1] = "wrong label";
    assertThrows(IllegalArgumentException.class,() -> DatasetAnalyzer.getDistance(map, col_names), "empty map should throw Exception");

    map.clear();

    assertThrows(IllegalArgumentException.class,() -> DatasetAnalyzer.getDistance(map, col_names), "empty map should throw Exception");





  }


  @Test
  void testGetValueWithSmallestDistanceWithReader() {
    try {
      String path = "football.csv";
      var reader = new CsvReader(path);
      String indexName = "Team";
      String[] relevantColumns = {"Goals", "Goals Allowed"};

      String winning_team =DatasetAnalyzer.getValueWithSmallestDistance(
          reader, indexName,
          relevantColumns);
      String expected_team = "Aston_Villa";

      assertEquals(expected_team, winning_team, "Teams are not equal");

    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}