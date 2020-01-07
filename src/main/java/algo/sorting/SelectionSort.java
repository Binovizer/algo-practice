package algo.sorting;

import algo.Sort;

import java.util.Arrays;

/**
 * The type SelectionSort
 *
 * @author Mohd Nadeem
 */
public class SelectionSort implements algo.sorting.Sort {

    public static void main(String[] args) {
        int[] arr = {3, 4, 1, 2, 5};
        Sort sort = new SelectionSort();
        sort.sort(arr);
        System.out.println("arr = " + Arrays.toString(arr));
    }

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
