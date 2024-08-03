package algo.practice.v1.arraysandstring;

import java.util.List;

/**
 * The type PatternSearch
 *
 * @author Mohd Nadeem
 */
public interface PatternSearch {

    /**
     * Returns list of indices found in algo.practice.old.arraysandstring for algo.practice.old.pattern
     *
     * @param string algo.practice.old.arraysandstring to be searched
     * @param pattern algo.practice.old.pattern to be found
     * @return list of indices
     */
    List<Integer> search(String string, String pattern);

    /**
     * Returns true if found algo.practice.old.pattern in algo.practice.old.arraysandstring
     *
     * @param string algo.practice.old.arraysandstring to be searched
     * @param pattern algo.practice.old.pattern to be found
     * @return list of indices
     */
    boolean find(String string, String pattern);
}
