package arraysandstring;

import java.util.Arrays;

/**
 * The type RearrangeArray
 *
 * @author Mohd Nadeem
 */
public class RearrangeArray {

  public static void main(String[] args) {
    int[] arr = {11, 12, 13, 14, 15, 16, 17, 18};
    RearrangeArray rearrangeArray = new RearrangeArray();
    //        int[] rearrange = rearrangeArray.rearrange(arr);
    //        System.out.println(Arrays.toString(rearrange));
    //        rearrangeArray.rearrangeWithoutSpace(arr);
    rearrangeArray.rearrangeWithoutSpaceLinear(arr);
    System.out.println("Rearranged Array : " + Arrays.toString(arr));
  }

  public int[] rearrange(int[] arr) {
    int[] ans = new int[arr.length];
    int i = 0;
    int j = arr.length - 1;
    int count = 0;
    while (i < j) {
      ans[count++] = arr[i++];
      ans[count++] = arr[j--];
    }
    return ans;
  }

  public void rearrangeWithoutSpace(int[] arr) {
    int n = arr.length;
    for (int i = 1; i < arr.length; i += 2) {
      int temp = arr[n - 1];
      for (int j = n - 1; j > i; j--) {
        arr[j] = arr[j - 1];
      }
      arr[i] = temp;
    }
  }

  public void rearrangeWithoutSpaceLinear(int[] arr) {
    int n = arr.length;
    int minIndex = 0;
    int maxIndex = n - 1;
    int maxElement = arr[maxIndex] + 1;
    for (int i = 0; i < n; i++) {
      if (i % 2 == 0) {
        arr[i] += (arr[maxIndex] % maxElement) * maxElement;
        maxIndex--;
      } else {
        arr[i] += (arr[minIndex] % maxElement) * maxElement;
        minIndex++;
      }
    }
    for (int i = 0; i < arr.length; i++) {
      arr[i] = arr[i] / maxElement;
    }
  }
}
