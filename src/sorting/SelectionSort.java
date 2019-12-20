package sorting;

/**
 * The type SelectionSort
 *
 * @author Mohd Nadeem
 */
public class SelectionSort implements Sort {

  @Override
  public void sort(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        if (arr[i] > arr[j]) {
          int temp = arr[i];
          arr[i] = arr[j];
          arr[j] = temp;
        }
      }
    }
  }
}
