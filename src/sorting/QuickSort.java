package sorting;

import java.util.Arrays;

/**
 * The type QuickSort
 *
 * @author Mohd Nadeem
 */
public class QuickSort implements Sort {

    public static void main(String[] args) {
        int[] arr = {3, 4, 1, 2, 5};
        Sort sort = new QuickSort();
        sort.sort(arr);
        System.out.println("arr = " + Arrays.toString(arr));
    }

    @Override
    public void sort(int[] arr) {
        sortUtil(arr, 0, arr.length - 1);
    }

    public void sortUtil(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            sortUtil(arr, low, pi - 1);
            sortUtil(arr, pi + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int smallerIndex = low - 1;
        for (int i = low; i < high; i++) {
            if (arr[i] <= pivot) {
                smallerIndex++;

                int temp = arr[smallerIndex];
                arr[smallerIndex] = arr[i];
                arr[i] = temp;
            }
        }
        int temp = arr[high];
        arr[high] = arr[smallerIndex + 1];
        arr[smallerIndex + 1] = temp;
        return smallerIndex + 1;
    }
}
