package algo.arraysandstring;

import java.util.ArrayList;
import java.util.List;

/**
 * The type NaivePatternSearch
 *
 * @author Mohd Nadeem
 */
public class NaivePatternSearch implements PatternSearch {

    @Override
    public List<Integer> search(String str, String pattern) {
        List<Integer> indices = new ArrayList<>();
        char begin = pattern.charAt(0);
        int strLen = str.length();
        int patternLen = pattern.length();
        for (int i = 0; i <= strLen - patternLen; i++) {
            if (str.charAt(i) == begin) {
                boolean found = true;
                for (int j = 0; j < patternLen; j++) {
                    if (pattern.charAt(j) != str.charAt(i + j)) {
                        found = false;
                        break;
                    }
                }
                if (found) {
                    indices.add(i);
                }
            }
        }
        return indices;
    }

    @Override
    public boolean find(String str, String pattern) {
        char begin = pattern.charAt(0);
        int strLen = str.length();
        int patternLen = pattern.length();
        for (int i = 0; i <= strLen - patternLen; i++) {
            if (str.charAt(i) == begin) {
                boolean found = true;
                for (int j = 0; j < patternLen; j++) {
                    if (pattern.charAt(j) != str.charAt(i + j)) {
                        found = false;
                        break;
                    }
                }
                if (found) {
                    return true;
                }
            }
        }
        return false;
    }
}
