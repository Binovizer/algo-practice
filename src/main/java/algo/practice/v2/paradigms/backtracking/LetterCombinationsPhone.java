package algo.practice.v2.paradigms.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This is the description of what this type does
 *
 * @author Nadeem 2020-12-11
 */
public class LetterCombinationsPhone {

    private List<String> combinations;

    private Map<Integer, String> digitToCharMap;

    {
        digitToCharMap = new HashMap<>();
        digitToCharMap.put(0, "0");
        digitToCharMap.put(1, "1");
        digitToCharMap.put(2, "abc");
        digitToCharMap.put(3, "def");
        digitToCharMap.put(4, "ghi");
        digitToCharMap.put(5, "jkl");
        digitToCharMap.put(6, "mno");
        digitToCharMap.put(7, "pqrs");
        digitToCharMap.put(8, "tuv");
        digitToCharMap.put(9, "wxyz");
    }

    public static void main(String[] args) {
        String digits = "23";
        LetterCombinationsPhone letterCombinationsPhone = new LetterCombinationsPhone();
        List<String> strings = letterCombinationsPhone.letterCombinations(digits);
        System.out.println(strings);
    }

    public List<String> letterCombinations(String digits) {
        combinations = new ArrayList<>();
        if (digits.length() < 1) {
            return combinations;
        }
        getCombinations(digits, "", 0);
        return combinations;
    }

    private void getCombinations(String str, String out, int index) {
        if (index == str.length()) {
            combinations.add(out);
            return;
        }
        int digit = str.charAt(index) - '0';
        String mappingChars = digitToCharMap.get(digit);
        for (char c : mappingChars.toCharArray()) {
            out += c;
            getCombinations(str, out, index + 1);
            out = out.substring(0, out.length() - 1);
        }
    }
}
