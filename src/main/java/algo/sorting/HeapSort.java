package algo.sorting;

import java.util.Arrays;

/**
 * The type HeapSort
 *
 * @author Mohd Nadeem
 */
public class HeapSort implements algo.sorting.Sort {

    public static void main(String[] args) {
        int[] arr = {3, 4, 1, 2, 5};
        Sort sort = new HeapSort();
        sort.sort(arr);
        System.out.println("arr = " + Arrays.toString(arr));
    }

    @Override
    public void sort(int[] arr) {
        int n = arr.length;
        // Build Max Heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            maxHeapify(arr, n, i);
        }

        // Extract Max Heap
        for (int i = n - 1; i >= 0; i--) {
            swap(arr, i, 0);
            maxHeapify(arr, i, 0);
        }
    }

    private void maxHeapify(int[] arr, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }
        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }
        if (largest != i) {
            swap(arr, largest, i);
            maxHeapify(arr, n, largest);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
