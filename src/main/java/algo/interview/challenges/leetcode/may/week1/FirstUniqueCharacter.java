package algo.interview.challenges.leetcode.may.week1;

import java.util.HashMap;

public class FirstUniqueCharacter {

    public int firstUniqueChar(String s) {
        HashMap<Character, Integer> count = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < n; i++) {
            if (count.get(s.charAt(i)) == 1) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        String str = "loveleetcode";
        FirstUniqueCharacter firstUniqueCharacter = new FirstUniqueCharacter();
        int index = firstUniqueCharacter.firstUniqueChar(str);
        System.out.println("index = " + index);
    }
}
