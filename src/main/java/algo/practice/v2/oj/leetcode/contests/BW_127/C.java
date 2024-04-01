package algo.practice.v2.oj.leetcode.contests.BW_127;

/**
 * The type C
 *
 * @author nadeem Date : 02/04/24
 */
public class C {
    private void update(int[] bits, int x, int change) {
        // insert or remove element from window, time: O(32)
        for (int i = 0; i < 32; i++) {
            if (((x >> i) & 1) != 0) {
                bits[i] += change;
            }
        }
    }

    private int bitsToNum(int[] bits) {
        // convert 32-size bits array to integer, time: O(32)
        int result = 0;
        for (int i = 0; i < 32; i++) {
            if (bits[i] != 0) {
                result |= 1 << i;
            }
        }
        return result;
    }

    public int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length, result = n + 1;
        int[] bits = new int[32];
        for (int start = 0, end = 0; end < n; end++) {
            update(bits, nums[end], 1); // insert nums[end] into window
            while (start <= end && bitsToNum(bits) >= k) {
                result = Math.min(result, end - start + 1);
                update(bits, nums[start++], -1); // remove nums[start] from window
            }
        }
        return result != n + 1 ? result : -1;
    }
}
