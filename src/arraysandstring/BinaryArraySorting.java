package arraysandstring;

import java.util.Arrays;

/**
 * The type BinaryArraySort
 *
 * @author Mohd Nadeem
 */
public class BinaryArraySorting {

  public static void main(String[] args) {
    int[] arr = new int[] {0, 1, 0, 0, 1, 0, 1, 0, 1, 0};
    BinaryArraySorting binaryArraySorting = new BinaryArraySorting();
    binaryArraySorting.sort(arr);
    System.out.println(Arrays.toString(arr));
  }

  private void sort(int[] arr) {
    int zero = 0;
    int one = arr.length - 1;
    while (zero < one) {
      if (arr[zero] == 1) {
        int temp = arr[zero];
        arr[zero] = arr[one];
        arr[one] = temp;
        one--;
      } else {
        zero++;
      }
    }
  }
}
