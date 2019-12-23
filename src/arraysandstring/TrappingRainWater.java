package arraysandstring;

/**
 * The type TrappingRainWater
 *
 * @author Mohd Nadeem
 */
public class TrappingRainWater {

  public static void main(String[] args) {
    int[] arr = new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    int water = calculateWaterTrapped(arr);
    System.out.println("water = " + water);
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
}
