package algo.practice.v2.oj.leetcode.practice.grind169;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * The type P_525
 *
 * @author nadeem Date : 26/07/24
 */
public class P_525 {
    public static void main(String[] args) {
        P_525 p525 = new P_525();
        int maxLength = p525.findMaxLength(new int[] {0, 0, 1});
        System.out.println("maxLength = " + maxLength);
    }

    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int maxLen = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = count + (nums[i] == 0 ? -1 : 1);
            if (map.containsKey(count)) {
                maxLen = Math.max(maxLen, i - map.get(count));
            }
            map.putIfAbsent(count, i);
        }
        return maxLen;
    }
}
