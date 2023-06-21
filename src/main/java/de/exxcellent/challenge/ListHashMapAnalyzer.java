package de.exxcellent.challenge;

import java.io.IOException;
import java.io.StreamCorruptedException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListHashMapAnalyzer {

  /**
   * gets a hashmap which represents a line of a dataframe and calculates the distance between two values
   * @param line represents a line in a dataset
   * @param columns is a string array with length 2 and contains the column names for the relevant values
   * @return the distance between
   */
  public static double getDistance(HashMap<String, String> line, String[] columns) {
    if(columns.length != 2) {
      throw new IllegalArgumentException("There should be 2 columns");
    }
    double[] values = new double[2];
    for(int i=0; i < values.length; i++) {
      String columnName = columns[i];
      // check key
      if(!line.containsKey(columnName)) {
        throw new IllegalArgumentException("Map doesn't contain key: " +  columnName);
      }
      values[i] = Double.parseDouble(line.get(columnName));
    }
    return ListHashMapAnalyzer.calcDistance(values[0], values[1]);
  }

  /**
   * Simple distance calculation of two values
   * @return |a-b|
   */
  private static double calcDistance(double a, double b) {
    return Math.abs(a - b);
  }

  /**
   * Iterates through a list of HashMaps and returns the index value for smallest distance-
   * @param dataframe is a list of maps
   * @param index_column is the column name for the index column. Such as team name or day
   * @param value_columns contains an array with 2 elements which represents the relevant columns for measuring the distance
   * @return the index value for the best line
   */
  public String getValueWithSmallestDistance(List<HashMap<String, String>> dataframe, String index_column, String[] value_columns) {
    String bestResult = null;
    double minDistance = Double.MAX_VALUE;
    for (var line: dataframe) {
      double distance = getDistance(line, value_columns);
      if(distance < minDistance) {
        minDistance = distance;
        bestResult = line.get(index_column);
      }
    }
    return bestResult;

  }

  /**
   * memory efficient calculation for value with smallest distance between two given column values
   * @param datareader is a csv reader
   * @param index_column is the column name for index
   * @param value_columns are the names for the relevant column names
   * @return the index value for the smallest distance
   */
  public static String getValueWithSmallestDistance(ICSVReader datareader, String index_column, String[] value_columns)
      throws IOException {
    String bestResult = null;
    double minDistance = Double.MAX_VALUE;
    Map<String, String> line;

    while ((line = datareader.readLine()) != null) {
      double distance = getDistance((HashMap<String, String>) line, value_columns);
      if(distance < minDistance) {
        minDistance = distance;
        bestResult = line.get(index_column);
      }
    }
    return bestResult;
  }



}
