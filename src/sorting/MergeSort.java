package sorting;

import java.util.Arrays;

/**
 * The type MergeSort
 *
 * @author Mohd Nadeem
 */
public class MergeSort implements Sort {

    public static void main(String[] args) {
        int[] arr = {3, 4, 1, 2, 5};
        Sort sort = new MergeSort();
        sort.sort(arr);
        System.out.println("arr = " + Arrays.toString(arr));
    }

    @Override
    public void sort(int[] arr) {
        sortWrapper(arr, 0, arr.length - 1);
    }

    private void sortWrapper(int[] arr, int l, int r) {
        if (l < r) {
            int mid = (l + r) / 2;
            sortWrapper(arr, l, mid);
            sortWrapper(arr, mid + 1, r);
            merge(arr, l, mid, r);
        }
    }

    private void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] left = new int[n1];
        int[] right = new int[n2];

        System.arraycopy(arr, l, left, 0, n1);
        System.arraycopy(arr, m + 1, right, 0, n2);

        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k++] = left[i++];
        }
        while (j < n2) {
            arr[k++] = right[j++];
        }
    }
}
