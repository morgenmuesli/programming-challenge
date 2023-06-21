package de.exxcellent.challenge;

import com.opencsv.CSVReaderHeaderAware;
import com.opencsv.CSVReaderHeaderAwareBuilder;

import com.opencsv.exceptions.CsvValidationException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * This class is a Wrapper for the opencsv reader.
 * A bett
 *
 */
public class CsvReader implements IReader {

  private CSVReaderHeaderAware reader;
  public CsvReader(String path) throws IOException {
    InputStream inputStream = CsvReader.class.getClassLoader().getResourceAsStream(path);
    if (inputStream == null) {
      throw new IOException("File not found: " + path);
    }
    this.reader = new CSVReaderHeaderAwareBuilder(new InputStreamReader(inputStream)).build();



  }

  /**
   * Reads a line of a csv File
   * @throws IOException if csv can't be parsed
   */
  public Map<String, String> readLine() throws IOException {
    try {
      return this.reader.readMap();
    }catch (CsvValidationException e) {
      throw new IOException(e);
    }

  }

  /**
   * reads and collects all lines of an csv file.
   * Be careful because
   * @return an array of all hashmaps
   * @throws IOException if csv can't be parsed
   */
  public List<Map<String, String>> readAll() throws IOException {
    ArrayList<Map<String, String>> records = new ArrayList<>();
    Map<String, String> value = null;
    while ((value= this.readLine()) != null) {
      records.add(value);

    }
    return records;

  }
}
