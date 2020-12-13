package algo.practice.v2.paradigms.recursion.gfg;

import static algo.practice.v2.utils.ArrayUtil.generateSequentialArray;
import static algo.practice.v2.utils.ArrayUtil.printArray;

/**
 * Problem Desc : https://www.geeksforgeeks.org/sum-triangle-from-array/
 *
 * @author Nadeem 2020-11-24
 */
public class SumTriangle {

    public static void main(String[] args) {
        int[] arr = generateSequentialArray(5, 1);
        printArray(arr);
        SumTriangle sumTriangle = new SumTriangle();
        int sum = sumTriangle.sum(arr);
        System.out.println("sum = " + sum);
    }

    private int sum(int[] arr) {
        return sum(arr, arr.length - 1);
    }

    /**
     * Sums the given array
     *
     * @param arr the array
     * @param index the index
     * @return the sum
     */
    private int sum(int[] arr, int index) {
        if (index == 0) {
            return arr[index];
        }
        shortenArray(arr, index);
        return sum(arr, index - 1);
    }

    /**
     * Shorten the array
     *
     * @param arr the array
     * @param index the index
     */
    private void shortenArray(int[] arr, int index) {
        shortenArray(arr, index, 0);
    }

    /**
     * Shorten the array
     *
     * @param arr the array
     * @param size the size
     * @param index the index
     */
    private void shortenArray(int[] arr, int size, int index) {
        if (index == size) {
            return;
        }
        arr[index] = arr[index] + arr[index + 1];
        shortenArray(arr, size, index + 1);
    }
}
