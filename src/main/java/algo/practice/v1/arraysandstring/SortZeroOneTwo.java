package algo.practice.v1.arraysandstring;

import java.util.Arrays;

public class SortZeroOneTwo {

    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 0, 2, 0, 2, 1, 2};
        SortZeroOneTwo sortZeroOneTwo = new SortZeroOneTwo();
        sortZeroOneTwo.sort(arr);
        System.out.println("arr = " + Arrays.toString(arr));
    }

    public void sort(int[] arr) {
        int zero = 0, one = 0, temp = 0;
        int two = arr.length - 1;
        while (one <= two) {
            if (arr[one] == 0) {
                temp = arr[one];
                arr[one] = arr[zero];
                arr[zero] = temp;

                zero++;
                one++;
            } else if (arr[one] == 1) {
                one++;
            } else {
                temp = arr[one];
                arr[one] = arr[two];
                arr[two] = temp;
                two--;
            }
        }
    }
}
