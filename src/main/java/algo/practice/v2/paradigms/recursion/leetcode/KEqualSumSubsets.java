package algo.practice.v2.paradigms.recursion.leetcode;

/**
 * This is the description of what this type does
 *
 * @author Nadeem 2020-11-28
 */
public class KEqualSumSubsets {

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 3, 5, 2, 1};
        int k = 4;

        KEqualSumSubsets kEqualSumSubsets = new KEqualSumSubsets();
        boolean canPartitionKSubsets = kEqualSumSubsets.canPartitionKSubsets(nums, k);
        System.out.println("canPartitionKSubsets = " + canPartitionKSubsets);
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int n : nums) sum += n;
        if (sum % k != 0) return false;
        if (nums.length < k) return false;
        return canPartition(nums, new boolean[nums.length], 0, k, 0, sum / k);
    }

    private boolean canPartition(
            int[] nums, boolean[] used, int start, int k, int curSum, int subSum) {
        if (k == 1) return true;
        if (curSum > subSum) return false;
        if (curSum == subSum) return canPartition(nums, used, 0, k - 1, 0, subSum);

        for (int i = start; i < nums.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            if (canPartition(nums, used, i + 1, k, curSum + nums[i], subSum)) return true;
            used[i] = false;
        }

        return false;
    }
}
