package algo.practice.v1.sorting;

import java.util.Arrays;

/**
 * The type BubbleSort
 *
 * @author Mohd Nadeem
 */
public class BubbleSort implements algo.practice.v1.sorting.Sort {

    public static void main(String[] args) {
        int[] arr = {3, 4, 1, 2, 5};
        algo.practice.v1.sorting.Sort sort = new BubbleSort();
        sort.sort(arr);
        System.out.println("arr = " + Arrays.toString(arr));
    }

    @Override
    public void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
