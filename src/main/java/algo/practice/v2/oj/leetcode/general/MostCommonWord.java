package algo.practice.v2.oj.leetcode.general;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/most-common-word/
 *
 * @author Nadeem 2021-03-06
 */
public class MostCommonWord {

    public static final String NOT_LETTER_REGEX = "[^a-zA-Z0-9 ]";
    public static final String SPACE_REGEX = "\\s+";
    public static final String SPACE = " ";

    public static void main(String[] args) {
        String paragraph = "Bob. hIt, baLl";
        String[] banned = {"bob", "hit"};
        MostCommonWord mostCommonWord = new MostCommonWord();
        String commonWord = mostCommonWord.mostCommonWord(paragraph, banned);
        System.out.println("commonWord = " + commonWord);
    }

    private boolean isBanned(String word, String[] bannedWords) {
        for (String bannedWord : bannedWords) {
            if (word.trim().equalsIgnoreCase(bannedWord.trim())) {
                return true;
            }
        }
        return false;
    }

    public String mostCommonWord(String paragraph, String[] bannedWords) {
        String normalizedStr = paragraph.replaceAll(NOT_LETTER_REGEX, SPACE).toLowerCase();
        String[] words = normalizedStr.split(SPACE_REGEX);

        String ans = "";
        int maxCount = 0;
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (isBanned(word, bannedWords)) {
                continue;
            }
            map.put(word, map.getOrDefault(word, 0) + 1);
            if (map.get(word) > maxCount) {
                ans = word;
                maxCount = map.get(word);
            }
        }
        return ans;
    }
}
