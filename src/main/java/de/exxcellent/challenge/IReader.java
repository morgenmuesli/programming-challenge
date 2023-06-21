package de.exxcellent.challenge;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/** Interface class for csv reader.
 * This ensures that you can use different csv readers if opencsv will not be maintained in the future
 */
public interface IReader {
  Map<String, String> readLine() throws IOException;

  List<Map<String, String>> readAll() throws IOException;
}
