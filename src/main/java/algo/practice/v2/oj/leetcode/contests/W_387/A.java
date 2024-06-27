package algo.practice.v2.oj.leetcode.contests.W_387;

import java.util.ArrayList;
import java.util.List;

/**
 * The type A
 *
 * <p><a
 * href="https://leetcode.com/contest/weekly-contest-387/problems/distribute-elements-into-two-arrays-i/">Problem
 * Link</a>
 *
 * @author nadeem Date : 07/03/24
 */
public class A {
    public int[] resultArray(int[] nums) {
        List<Integer> one = new ArrayList<>();
        List<Integer> two = new ArrayList<>();
        for (int num : nums) {
            if (one.isEmpty()) {
                one.add(num);
                continue;
            }
            if (two.isEmpty()) {
                two.add(num);
                continue;
            }
            if (one.get(one.size() - 1) > two.get(two.size() - 1)) {
                one.add(num);
            } else {
                two.add(num);
            }
        }
        one.addAll(two);
        return one.stream().mapToInt(i -> i).toArray();
    }
}
