package algo.interview.challenges.leetcode.dec.week2;

/** @author Nadeem 2020-12-11 */
public class RemoveDuplicatesII {

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 2, 2, 3, 3, 3, 4, 5, 5, 5};
        RemoveDuplicatesII removeDuplicatesII = new RemoveDuplicatesII();
        int length = removeDuplicatesII.removeDuplicates(nums);
        for (int i = 0; i < length; i++) {
            System.out.println(nums[i] + " ");
        }
    }

    private int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 1;
        }
        int u = 1;
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[u++] = nums[i];
                count = 1;
            } else {
                if (count < 2) {
                    nums[u++] = nums[i];
                }
                count++;
            }
        }
        return u;
    }
}
