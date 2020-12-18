package algo.practice.v2.platforms.leetcode.challenges.dec.week3;

import java.util.Arrays;

/**
 * This is the description of what this type does
 *
 * @author Nadeem 2020-12-17
 */
public class SquareOfSortedArray {

    public static void main(String[] args) {
        int[] nums = {-4, -3, 0, 1, 2, 3, 4};
        SquareOfSortedArray square = new SquareOfSortedArray();
        int[] squares = square.sortedSquares(nums);
        System.out.println("squares = " + Arrays.toString(squares));
    }

    public int[] sortedSquares(int[] nums) {
        return getSquaresTwoPointersOptimized(nums);
    }

    private int[] getSquaresTwoPointersOptimized(int[] nums) {
        int n = nums.length;
        int[] squares = new int[n];
        int start = 0;
        int end = n - 1;
        int k = n - 1;
        while (start <= end) {
            if (Math.abs(nums[start]) <= Math.abs(nums[end])) {
                squares[k--] = nums[end] * nums[end];
                end--;
            } else {
                squares[k--] = nums[start] * nums[start];
                start++;
            }
        }
        return squares;
    }

    private int[] getSquaresTwoPointers(int[] nums) {
        int n = nums.length;
        int positiveIndex = findPositiveIndex(nums);
        int right = positiveIndex;
        int left = positiveIndex - 1;
        int[] squares = new int[n];
        int k = 0;
        while (right < n && left >= 0) {
            if (Math.abs(nums[left]) <= Math.abs(nums[right])) {
                squares[k++] = nums[left] * nums[left];
                left--;
            } else {
                squares[k++] = nums[right] * nums[right];
                right++;
            }
        }
        while (left >= 0) {
            squares[k++] = nums[left] * nums[left];
            left--;
        }
        while (right < n) {
            squares[k++] = nums[right] * nums[right];
            right++;
        }
        return squares;
    }

    private int findPositiveIndex(int[] nums) {
        int n = nums.length;
        int i = 0;
        if (nums[i] >= 0) {
            return 0;
        }
        if (nums[n - 1] <= 0) {
            return n - 1;
        }
        while (i < n && nums[i] < 0) {
            i++;
        }
        return i;
    }

    private int[] getSquares(int[] nums) {
        int n = nums.length;
        int[] squares = new int[n];
        Arrays.fill(squares, -1);
        for (int num : nums) {
            insert(squares, num * num);
        }
        return squares;
    }

    private void insert(int[] arr, int num) {
        int n = arr.length;
        int i = 0;
        while (i < n && arr[i] != -1 && arr[i] < num) {
            i++;
        }
        if (i == n - 1) {
            arr[n - 1] = num;
            return;
        }
        int temp = arr[i];
        arr[i] = num;
        int j = n - 1;
        while (j >= 1 && j >= i + 2) {
            arr[j] = arr[j - 1];
            j--;
        }
        arr[i + 1] = temp;
    }
}
