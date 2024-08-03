package algo.practice.v2.oj.leetcode.practice.grind169;

import java.util.HashSet;
import java.util.Set;

/**
 * The type P_3
 *
 * @author nadeem Date : 20/07/24
 */
public class P_3 {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();

        int maxLen = 0;

        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                while (s.charAt(start) != c) {
                    set.remove(s.charAt(start));
                    start++;
                }
                set.remove(c);
                start += 1;
            }
            maxLen = Math.max(maxLen, i - start + 1);

            set.add(c);
        }
        return maxLen;
    }
}
