package algo.practice.v1.arraysandstring;

import java.util.Arrays;

public class ZigZag {

    public static void main(String[] args) {
        int[] arr = {4, 3, 7, 8, 6, 2, 1};
        ZigZag zigZag = new ZigZag();
        zigZag.convertToZigZag(arr);
        System.out.println("arr = " + Arrays.toString(arr));
    }

    public void convertToZigZag(int[] arr) {
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            if (flag) {
                if (arr[i] < arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            } else {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
            flag = !flag;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
