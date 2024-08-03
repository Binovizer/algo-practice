package algo.practice.v2.paradigms.dp.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/jump-game/
 *
 * @author Nadeem 2020-12-10
 */
public class JumpGame {

    private int[] dp;

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        JumpGame jumpGame = new JumpGame();
        boolean canReach = jumpGame.canReachBottomUp(nums);
        System.out.println("canReach = " + canReach);
    }

    private boolean canReach(int[] nums) {
        dp = new int[nums.length + 1];
        Arrays.fill(dp, -1);
        return canReachMemo(nums, 0, nums.length - 1) == 1;
    }

    private boolean canReach(int[] nums, int curIndex, int lastIndex) {
        if (curIndex + nums[curIndex] >= lastIndex) {
            return true;
        }
        if (curIndex == lastIndex) {
            return true;
        }
        for (int i = 1; i <= nums[curIndex]; i++) {
            if (canReach(nums, curIndex + i, lastIndex)) {
                return true;
            }
        }
        return false;
    }

    private int canReachMemo(int[] nums, int curIndex, int lastIndex) {
        if (curIndex + nums[curIndex] >= lastIndex) {
            return 1;
        }
        if (curIndex == lastIndex) {
            return 1;
        }
        if (dp[curIndex] != -1) {
            return dp[curIndex];
        }
        for (int i = 1; i <= nums[curIndex]; i++) {
            if (dp[curIndex + i] == -1) {
                dp[curIndex + i] = canReachMemo(nums, curIndex + i, lastIndex);
            }
            if (dp[curIndex + i] == 1) {
                return 1;
            }
        }
        return 0;
    }

    private boolean canReachBottomUp(int[] nums) {
        int n = nums.length - 1;
        boolean[] dp = new boolean[n + 1];
        dp[n] = true;
        for (int i = n - 1; i >= 0; i--) {
            boolean flag = false;
            for (int j = nums[i]; j >= 1; j--) {
                if (i + j >= n || dp[i + j]) {
                    flag = true;
                    break;
                }
            }
            dp[i] = flag;
        }
        return dp[0];
    }
}
