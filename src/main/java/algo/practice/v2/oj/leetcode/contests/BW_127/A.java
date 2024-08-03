package algo.practice.v2.oj.leetcode.contests.BW_127;

import java.util.*;

/**
 * The type A
 *
 * @author nadeem Date : 02/04/24
 */
public class A {

    public int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        for (int len = 1; len <= n; len++) {
            for (int start = 0; start + len <= n; start++) {
                int from = start;
                int end = start + len;
                int x = 0;
                while (from < end) {
                    x |= nums[from];
                    from++;
                }
                // System.out.println("from " + from);
                // System.out.println("end " + end);
                // System.out.println("len " + len);
                // System.out.println("x " + x);
                if (x >= k) {
                    return len;
                }
            }
        }
        return -1;
    }
}
