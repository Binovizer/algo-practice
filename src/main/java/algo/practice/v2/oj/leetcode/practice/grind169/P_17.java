package algo.practice.v2.oj.leetcode.practice.grind169;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The type P17
 *
 * @author nadeem Date : 26/07/24
 */
public class P_17 {
    public static void main(String[] args) {
        P_17 p17 = new P_17();
        List<String> combinations = p17.letterCombinations("");
        System.out.println("combinations = " + combinations);
    }

    private Map<Character, String> map;
    private List<String> ans;

    public List<String> letterCombinations(String digits) {
        initMap();
        ans = new ArrayList<>();
        if(digits.isEmpty()) return ans;

        dfs(digits, 0, "", digits.length());

        return ans;
    }

    private void dfs(String digits, int index, String current, int n) {
        if (index == n) {
            ans.add(current);
            return;
        }

        char c = digits.charAt(index);
        for (char option : map.get(c).toCharArray()) {
            dfs(digits, index + 1, current + option, n);
        }
    }

    private void initMap() {
        map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }
}
