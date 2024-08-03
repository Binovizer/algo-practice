package algo.practice.v2.paradigms.recursion.leetcode;

/**
 * Problem Desc :
 * https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
 *
 * @author Nadeem 2020-11-28
 */
public class LongestSubstringWithAtLeastKRepeating {

    public static void main(String[] args) {
        String str = "aaabb";
        int k = 3;
        LongestSubstringWithAtLeastKRepeating obj = new LongestSubstringWithAtLeastKRepeating();
        int longestSubstring = obj.longestSubstring(str, k);
        System.out.println("longestSubstring = " + longestSubstring);
    }

    /**
     * Given a String s and an integer k, return the longest "valid" substring, where a substring is
     * valid iff every character in the substring occurs at least k times.
     *
     * @param s The given String
     * @param k The minimum number of times all substring characters must occur
     * @return The length of the longest valid substring
     */
    public int longestSubstring(String s, int k) {

        // Call divide and conquer helper method
        return div(s, 0, s.length(), k);
    }

    /**
     * Determines the length of the longest valid substring.
     *
     * <p>We achieve this by recursively splitting the given String on characters who do not occur
     * at least k times (since they cannot be part of the longest valid substring).
     *
     * <p>Note that the substring of the current recursion is always equivalent to
     * s.substring(start, end). For space reasons, we don't ever actually create a new substring.
     *
     * @param s The given String
     * @param start The beginning of the substring, inclusive
     * @param end The end of the substring, exclusive
     * @param k The minimum number of times all substring characters must occur
     * @return The length of the longest valid substring
     */
    private int div(String s, int start, int end, int k) {

        /**
         * Base Case 1 of 2:
         *
         * <p>If this substring is shorter than k, then no characters in it can be repeated k times,
         * therefore this substring and all substrings that could be formed from it are invalid,
         * therefore return 0.
         */
        if (end - start < k) return 0;

        /**
         * Count the frequency of characters in this substring.
         *
         * <p>We are guaranteed from the problem statement that the given String can only contain
         * lowercase (English?) characters, so we use a table of length 26 to store the character
         * counts.
         */
        int[] a = new int[26];
        for (int i = start; i < end; i++) {
            a[s.charAt(i) - 'a']++;
        }

        // For every character in the above frequency table
        for (int i = 0; i < a.length; i++) {

            /**
             * If this character occurs at least once, but fewer than k times in this substring, we
             * know: (1) this character cannot be part of the longest valid substring, (2) the
             * current substring is not valid.
             *
             * <p>Hence, we will "split" this substring on this character, wherever it occurs, and
             * check the substrings formed by that split
             */
            if (a[i] > 0 && a[i] < k) {

                /** Look for each occurrence of this character (i + 'a') in this substring. */
                for (int j = start; j < end; j++) {
                    if (s.charAt(j) == i + 'a') {

                        // "Split" into two substrings to solve recursively
                        int l = div(s, start, j, k);
                        int r = div(s, j + 1, end, k);
                        return Math.max(l, r);
                    }
                }
            }
        }

        /**
         * Base Case 2 of 2:
         *
         * <p>If every character in this substring occurs at least k times, then this is a valid
         * substring, so return this substring's length.
         */
        return end - start;
    }
}
