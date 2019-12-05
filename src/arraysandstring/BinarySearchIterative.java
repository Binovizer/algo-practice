package arraysandstring;

/**
 * The type BinarySearch
 *
 * @author Mohd Nadeem
 */
public class BinarySearchIterative {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int index = binarySearch(arr, 7);
        System.out.println(index);
    }

    private static int binarySearch(int[] arr, int element) {
        int low = 0;
        int high = arr.length - 1;
        while(low <= high){
            int mid = (low + high)/2;
            if(arr[mid] == element){
                return mid;
            } else if(arr[mid] > element) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
