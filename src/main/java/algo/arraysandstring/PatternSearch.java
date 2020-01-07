package algo.arraysandstring;

import java.util.List;

/**
 * The type PatternSearch
 *
 * @author Mohd Nadeem
 */
public interface PatternSearch {

    /**
     * Returns list of indices found in algo.arraysandstring for algo.pattern
     *
     * @param string algo.arraysandstring to be searched
     * @param pattern algo.pattern to be found
     * @return list of indices
     */
    List<Integer> search(String string, String pattern);

    /**
     * Returns true if found algo.pattern in algo.arraysandstring
     *
     * @param string algo.arraysandstring to be searched
     * @param pattern algo.pattern to be found
     * @return list of indices
     */
    boolean find(String string, String pattern);
}
