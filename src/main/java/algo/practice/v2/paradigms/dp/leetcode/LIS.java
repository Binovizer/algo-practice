package algo.practice.v2.paradigms.dp.leetcode;

import java.util.Arrays;

/**
 * This is the description of what this type does
 *
 * @author Nadeem 2020-12-10
 */
public class LIS {

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        LIS lis = new LIS();
        int lengthOfLIS = lis.lengthOfLISV2BottomUp(nums);
        System.out.println("lengthOfLIS = " + lengthOfLIS);
    }

    public int lengthOfLIS(int[] nums) {
        return lengthOfLISV2(nums, 0, Integer.MIN_VALUE);
    }

    private int lengthOfLIS(int[] nums, int n, int maxValue) {
        if (n < 0) {
            return 0;
        }
        int taken = 0;
        if (nums[n] < maxValue) {
            taken = 1 + lengthOfLIS(nums, n - 1, nums[n]); // If being selected in sequence
        }
        int notTaken = lengthOfLIS(nums, n - 1, maxValue); // If not being selected in sequence
        return Math.max(taken, notTaken);
    }

    private int lengthOfLISV2(int[] nums, int current, int minValue) {
        if (current == nums.length) {
            return 0;
        }
        int taken = 0;
        if (nums[current] > minValue) {
            taken =
                    1
                            + lengthOfLISV2(
                                    nums,
                                    current + 1,
                                    nums[current]); // If being selected in sequence
        }
        int notTaken =
                lengthOfLISV2(nums, current + 1, minValue); // If not being selected in sequence
        return Math.max(taken, notTaken);
    }

    private int lengthOfLISV2BottomUp(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1);
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
