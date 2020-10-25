package algo.interview.sortingsearching;

/**
 * This is the description of what this type does
 *
 * @author Nadeem 2020-10-25
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5, 5, 5, 6};
        BinarySearch binarySearch = new BinarySearch();
        for (int value : arr) {
            int index = binarySearch.binarySearchFirstOccurrence(arr, value);
            System.out.println("value = " + value + ", index = " + index);
        }
    }

    public int binarySearch(int[] arr, int k) {
        return binarySearch(arr, 0, arr.length - 1, k);
    }

    private int binarySearch(int[] arr, int l, int r, int k) {
        if (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] == k) {
                return mid;
            } else if (arr[mid] < k) {
                return binarySearch(arr, mid + 1, r, k);
            } else {
                return binarySearch(arr, l, mid - 1, k);
            }
        }
        return -1;
    }

    public int binarySearchFirstOccurrence(int[] arr, int k) {
        return binarySearchFirstOccurrence(arr, 0, arr.length - 1, k);
    }

    private int binarySearchFirstOccurrence(int[] arr, int l, int r, int k) {
        if (l <= r) {
            int mid = l + (r - l) / 2;
            if ((mid == 0 || arr[mid - 1] < k) && arr[mid] == k) {
                return mid;
            } else if (arr[mid] < k) {
                return binarySearchFirstOccurrence(arr, mid + 1, r, k);
            } else {
                return binarySearchFirstOccurrence(arr, l, mid - 1, k);
            }
        }
        return -1;
    }

    public int binarySearchLastOccurrence(int[] arr, int k) {
        return binarySearchLastOccurrence(arr, 0, arr.length - 1, k, arr.length);
    }

    private int binarySearchLastOccurrence(int[] arr, int l, int r, int k, int n) {
        if (l <= r) {
            int mid = l + (r - l) / 2;
            if ((mid == n - 1 || arr[mid + 1] > k) && arr[mid] == k) {
                return mid;
            } else if (arr[mid] > k) {
                return binarySearchLastOccurrence(arr, l, mid - 1, k, n);
            } else {
                return binarySearchLastOccurrence(arr, mid + 1, r, k, n);
            }
        }
        return -1;
    }
}
