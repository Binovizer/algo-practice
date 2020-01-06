package arraysandstring;

/**
 * The type BinarySearch
 *
 * @author Mohd Nadeem
 */
public class BinarySearchIterative {

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7};
        //        int index = binarySearch(arr, 7);
        int index = binarySearchRecursive(arr, 7);
        System.out.println(index);
    }

    private static int binarySearch(int[] arr, int element) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == element) {
                return mid;
            } else if (arr[mid] > element) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    private static int binarySearchRecursive(int[] arr, int searchElement) {
        return binarySearchRecursiveUtil(arr, searchElement, 0, arr.length - 1);
    }

    private static int binarySearchRecursiveUtil(int[] arr, int searchElement, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (arr[mid] == searchElement) {
            return mid;
        } else if (arr[mid] < searchElement) {
            return binarySearchRecursiveUtil(arr, searchElement, mid + 1, end);
        } else {
            return binarySearchRecursiveUtil(arr, searchElement, start, mid - 1);
        }
    }
}
