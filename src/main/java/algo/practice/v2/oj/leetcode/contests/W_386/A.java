package algo.practice.v2.oj.leetcode.contests.W_386;

import java.util.HashMap;
import java.util.Map;

/**
 * The type A
 *
 * <p><a
 * href="https://leetcode.com/contest/weekly-contest-386/problems/split-the-array/">Problem</a>
 *
 * @author nadeem Date : 27/02/24
 */
public class A {
    public boolean isPossibleToSplit(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
            if (freq.get(num) > 2) {
                return false;
            }
        }
        return true;
    }
}
