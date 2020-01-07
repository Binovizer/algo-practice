package algo.sorting;

import java.util.Arrays;

/**
 * The type InsertionSort
 *
 * @author Mohd Nadeem
 */
public class InsertionSort implements algo.sorting.Sort {

    public static void main(String[] args) {
        int[] arr = {3, 4, 1, 2, 5};
        Sort sort = new InsertionSort();
        sort.sort(arr);
        System.out.println("arr = " + Arrays.toString(arr));
    }

    @Override
    public void sort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
            greater than key, to one position ahead
            of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
}
