package algo.practice.v1.arraysandstring;

/**
 * The type TrappingRainWater
 *
 * @author Mohd Nadeem
 */
public class TrappingRainWater {

    public static void main(String[] args) {
        //        int[] arr = new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] arr = {3, 0, 0, 2, 0, 4};
        //        int water = calculateWaterTrappedOptimized(arr);
        int water = calculateWaterTrappedOptimized2(arr);
        System.out.println("water trapped = " + water);
    }

    private static int calculateWaterTrapped(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = arr[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], arr[i]);
        }
        right[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(arr[i], right[i + 1]);
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.min(left[i], right[i]) - arr[i];
        }
        return sum;
    }

    private static int calculateWaterTrappedOptimized(int[] arr) {
        int n = arr.length;
        int leftMax = arr[0];
        int rightMax = Integer.MIN_VALUE;
        int rightMaxIndex = -1;
        for (int i = 0; i < n; i++) {
            if (rightMax <= arr[i]) {
                rightMax = arr[i];
                rightMaxIndex = i;
            }
        }
        int sum = 0;
        int i = 1;
        while (i < n) {
            while (i < rightMaxIndex) {
                if (leftMax > arr[i]) {
                    sum += Math.min(leftMax, rightMax) - arr[i];
                } else {
                    leftMax = arr[i];
                }
                i++;
            }
            leftMax = rightMax;
            rightMax = Integer.MIN_VALUE;
            rightMaxIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (rightMax <= arr[j]) {
                    rightMax = arr[j];
                    rightMaxIndex = j;
                }
            }
            i++;
        }
        return sum;
    }

    private static int calculateWaterTrappedOptimized2(int[] arr) {
        int n = arr.length;
        int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE;
        int lo = 0;
        int hi = n - 1;
        int sum = 0;
        while (lo < hi) {
            if (arr[lo] <= arr[hi]) {
                if (arr[lo] >= leftMax) {
                    leftMax = arr[lo];
                } else {
                    sum += leftMax - arr[lo];
                }
                lo++;
            } else {
                if (arr[hi] >= rightMax) {
                    rightMax = arr[hi];
                } else {
                    sum += rightMax - arr[hi];
                }
                hi--;
            }
        }
        return sum;
    }
}
