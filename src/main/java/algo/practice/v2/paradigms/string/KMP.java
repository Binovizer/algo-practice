package algo.practice.v2.paradigms.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The type KMP
 *
 * @author nadeem Date : 06/06/24
 */
public class KMP {

    public static void main(String[] args) {
        String text = "ABABDABACDABABCABAB";
        String pattern = "ABAB";

        KMP kmp = new KMP();
        List<Integer> startIndicesOfMatch = kmp.search(text, pattern);
        System.out.println("Match found at startIndicesOfMatch = " + startIndicesOfMatch);
    }

    private List<Integer> search(String text, String pattern) {
        List<Integer> startIndices = new ArrayList<>();
        if (text.length() < pattern.length()) return startIndices;

        int[] lps = generateLPSArray(pattern);
        System.out.println(Arrays.toString(lps));

        int i = 0;
        int j = 0;
        while (i < text.length()) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }
            if (j == pattern.length()) {
                startIndices.add(i - j);
                j = lps[j - 1];
            } else if (i < text.length() && text.charAt(i) != pattern.charAt(j)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return startIndices;
    }

    private int[] generateLPSArray(String pattern) {
        int n = pattern.length();
        int[] lps = new int[n];
        lps[0] = 0;
        int i = 1;
        int length = 0;
        while (i < n) {
            if (pattern.charAt(i) == pattern.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
