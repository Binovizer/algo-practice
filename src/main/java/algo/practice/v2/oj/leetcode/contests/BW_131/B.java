package algo.practice.v2.oj.leetcode.contests.BW_131;

import java.util.ArrayList;
import java.util.List;

/**
 * The type B
 *
 * @author nadeem Date : 25/05/24
 */
public class B {

    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == x) {
                list.add(i);
            }
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = (queries[i] > list.size()) ? -1 : list.get(queries[i] - 1);
        }
        return ans;
    }
}
