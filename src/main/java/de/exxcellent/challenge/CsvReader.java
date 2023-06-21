package de.exxcellent.challenge;

import com.opencsv.CSVIterator;
import com.opencsv.CSVReaderHeaderAware;
import com.opencsv.CSVReaderHeaderAwareBuilder;
import com.opencsv.bean.CsvToBean;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class is a Wrapper for the opencsv reader.
 * A bett
 *
 */
public class CsvReader implements ICSVReader{

  private CSVReaderHeaderAware reader;
  public CsvReader(String path) throws IOException {
    this.reader = new CSVReaderHeaderAwareBuilder(new FileReader(path)).build();



  }

  /**
   * Reads a line of a csv File
   * @return
   * @throws CsvValidationException
   * @throws IOException
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
   * @throws IOException
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
