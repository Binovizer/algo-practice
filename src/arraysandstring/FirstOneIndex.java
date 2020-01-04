package arraysandstring;

/**
 * The type FirstOneIndex
 *
 * @author Mohd Nadeem
 */
public class FirstOneIndex {

    public static void main(String[] args) {
        int[] arr = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1};
        FirstOneIndex firstOneIndex = new FirstOneIndex();
        int i = firstOneIndex.firstOneIndex(arr);
        System.out.println("i = " + i);
    }

    public int firstOneIndex(int[] arr) {
        return firstOneIndexUtil(arr, 0, arr.length - 1);
    }

    public int firstOneIndexUtil(int[] arr, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == 1 && (mid == 0 || arr[mid - 1] == 0)) {
                return mid;
            } else if (arr[mid] == 1) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
