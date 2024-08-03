package algo.practice.v2.oj.leetcode.challenges.dec.week2;

/**
 * This is the description of what this type does
 *
 * @author Nadeem 2020-11-28
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int newLength = removeDuplicates.removeDuplicates(arr);
        System.out.println("newLength = " + newLength);
    }

    public int removeDuplicates(int[] nums) {
        int uniqueIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[uniqueIndex]) {
                nums[++uniqueIndex] = nums[i];
            }
        }
        return uniqueIndex + 1;
    }
}
