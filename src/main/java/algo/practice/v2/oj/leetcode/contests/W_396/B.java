package algo.practice.v2.oj.leetcode.contests.W_396;

import java.util.HashMap;
import java.util.Map;

/**
 * The type B
 *
 * @author nadeem Date : 11/05/24
 */
public class B {
    public static void main(String[] args) {}

    public int minimumOperationsToMakeKPeriodic(String word, int k) {
        int n = word.length();

        Map<String, Integer> map = new HashMap<>();
        int maxCount = 0;
        for (int i = 0; i < n; i += k) {
            String sub = word.substring(i, i + k);
            int newCount = map.getOrDefault(sub, 0) + 1;
            maxCount = Math.max(maxCount, newCount);
            map.put(sub, newCount);
        }
        return (n / k) - maxCount;
    }
}
