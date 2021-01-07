package algo.practice.v2.platforms.leetcode.challenges.jan.week1;

import java.util.HashMap;
import java.util.Map;

/**
 * This is the description of what this type does
 *
 * @author Nadeem 2021-01-07
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String str = "abba";
        LongestSubstringWithoutRepeatingCharacters longestSubstringWithoutRepeatingCharacters =
                new LongestSubstringWithoutRepeatingCharacters();
        int longestSubstring =
                longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(str);
        System.out.println("longestSubstring = " + longestSubstring);
    }

    public int lengthOfLongestSubstring(String str) {
        Map<Character, Integer> lastLocationMap = new HashMap<>();
        int maxLen = 0;
        int currLen = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!lastLocationMap.containsKey(c)) {
                currLen += 1;
            } else {
                Integer lastLocation = lastLocationMap.get(c);
                if (i - currLen <= lastLocation) {
                    currLen = i - lastLocation;
                } else {
                    currLen += 1;
                }
            }
            lastLocationMap.put(c, i);
            maxLen = Math.max(maxLen, currLen);
        }
        return maxLen;
    }
}
