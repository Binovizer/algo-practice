package algo.practice.v2.platforms.interviewbit.arrays;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * This is the description of what this type does
 *
 * @author Nadeem 2020-12-15
 */
public class MaximumSumTriplet {

    public static void main(String[] args) {
        int[] arr = {
            18468, 6335, 26501, 19170, 15725, 11479, 29359, 26963, 24465, 5706, 28146, 23282, 16828,
            9962, 492, 2996, 11943, 4828, 5437, 32392, 14605
        };
        MaximumSumTriplet maximumSumTriplet = new MaximumSumTriplet();
        int maxSum = maximumSumTriplet.maxSumOptimized(arr);
        System.out.println("maxSum = " + maxSum);
    }

    private int maxSum(int[] arr) {
        int n = arr.length;
        int maxSum = 0;
        for (int i = 0; i <= n - 3; i++) {
            for (int j = i + 1; j <= n - 2; j++) {
                if (arr[i] >= arr[j]) {
                    continue;
                }
                for (int k = j + 1; k <= n - 1; k++) {
                    if (arr[j] >= arr[k]) {
                        continue;
                    }
                    maxSum = Math.max(maxSum, arr[i] + arr[j] + arr[k]);
                }
            }
        }
        return maxSum;
    }

    private int maxSumOptimized(int[] arr) {
        int n = arr.length;
        int[] maxSuffix = new int[n];
        maxSuffix[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxSuffix[i] = Math.max(maxSuffix[i + 1], arr[i]);
        }
        System.out.println("maxSuffix = " + Arrays.toString(maxSuffix));
        TreeSet<Integer> set = new TreeSet<>();
        set.add(Integer.MIN_VALUE);
        int maxSum = 0;
        for (int i = 0; i <= n - 2; i++) {
            if (maxSuffix[i + 1] > arr[i]) {
                int current = arr[i];
                int rightMax = maxSuffix[i + 1];
                Integer lower = set.lower(arr[i]);
                if (lower != null) {
                    maxSum = Math.max(maxSum, current + rightMax + lower);
                }
                set.add(arr[i]);
            }
        }
        return maxSum;
    }
}
