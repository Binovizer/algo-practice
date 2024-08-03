package algo.practice.v2.oj.leetcode.practice.grind169;

import java.util.HashMap;
import java.util.Map;

/**
 * The type P_1
 *
 * @author nadeem Date : 20/07/24
 */
public class P_1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[] {-1, -1};
    }
}
