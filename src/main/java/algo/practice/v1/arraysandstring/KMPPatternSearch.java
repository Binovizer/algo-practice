package algo.practice.v1.arraysandstring;

import java.util.ArrayList;
import java.util.List;

/**
 * The type KMPPatternSearch
 *
 * @author Mohd Nadeem
 */
public class KMPPatternSearch implements PatternSearch {

    @Override
    public List<Integer> search(String string, String pattern) {
        List<Integer> indices = new ArrayList<>();
        int[] lps = prepareLPSArray(pattern);
        int m = string.length();
        int n = pattern.length();
        int i = 0;
        int j = 0;
        while (i < m && j < n) {
            if (string.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
                if (j == n) {
                    indices.add(i - j);
                    j = lps[j - 1];
                }
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return indices;
    }

    @Override
    public boolean find(String string, String pattern) {
        int[] lps = prepareLPSArray(pattern);
        int m = string.length();
        int n = pattern.length();
        int i = 0;
        int j = 0;
        while (i < m && j < n) {
            if (string.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return j == n;
    }

    private int[] prepareLPSArray(String pattern) {
        int n = pattern.length();
        int[] lps = new int[n];
        int index = 0;
        int i = 1;
        while (i < n) {
            if (pattern.charAt(i) == pattern.charAt(index)) {
                lps[i] = index + 1;
                index++;
                i++;
            } else {
                if (index != 0) {
                    index = lps[index - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
