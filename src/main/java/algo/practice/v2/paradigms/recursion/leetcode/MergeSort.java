package algo.practice.v2.paradigms.recursion.leetcode;

import algo.practice.v2.utils.ArrayUtil;

import java.util.Arrays;

/**
 * This class implements the merge sort algorithm
 *
 * @author Nadeem 2020-11-29
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 5, 4};
        MergeSort mergeSort = new MergeSort();
        int[] sortedArray = mergeSort.sortArray(nums);
        ArrayUtil.printArray(sortedArray);
    }

    public int[] sortArray(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }
        int mid = nums.length / 2;
        int[] left = sortArray(Arrays.copyOfRange(nums, 0, mid));
        int[] right = sortArray(Arrays.copyOfRange(nums, mid, nums.length));
        return merge(left, right);
    }

    private int[] merge(int[] left, int[] right) {
        int[] res = new int[left.length + right.length];
        int leftCursor = 0;
        int rightCursor = 0;
        int resCursor = 0;
        while (leftCursor < left.length && rightCursor < right.length) {
            if (left[leftCursor] <= right[rightCursor]) {
                res[resCursor++] = left[leftCursor++];
            } else {
                res[resCursor++] = right[rightCursor++];
            }
        }
        while (leftCursor < left.length) {
            res[resCursor++] = left[leftCursor++];
        }
        while (rightCursor < right.length) {
            res[resCursor++] = right[rightCursor++];
        }
        return res;
    }
}
