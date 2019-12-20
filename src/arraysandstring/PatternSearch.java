package arraysandstring;

import java.util.List;

/**
 * The type PatternSearch
 *
 * @author Mohd Nadeem
 */
public interface PatternSearch {

  /**
   * Returns list of indices found in arraysandstring for pattern
   *
   * @param string arraysandstring to be searched
   * @param pattern pattern to be found
   * @return list of indices
   */
  List<Integer> search(String string, String pattern);

  /**
   * Returns true if found pattern in arraysandstring
   *
   * @param string arraysandstring to be searched
   * @param pattern pattern to be found
   * @return list of indices
   */
  boolean find(String string, String pattern);
}
