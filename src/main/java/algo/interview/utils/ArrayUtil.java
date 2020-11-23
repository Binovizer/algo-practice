package algo.interview.utils;

import java.util.Random;

/**
 * This is the description of what this type does
 *
 * @author Nadeem 2020-11-23
 */
public class ArrayUtil {

    /**
     * Prints the given 2D array
     *
     * @param arr the array
     */
    public static void print2DArray(int[][] arr) {
        System.out.println("::: Array :::");
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    /**
     * Prints the given 2D char array
     *
     * @param arr the array
     */
    public static void print2DArray(char[][] arr) {
        System.out.println("::: Array :::");
        for (char[] ints : arr) {
            for (char anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    /**
     * Generates a 2D array of size m*n with given range
     *
     * @param m the row
     * @param n the column
     * @param inclusiveStart the inclusive start of range
     * @param exclusiveEnd the exclusive end of range
     * @return the 2D Array
     */
    public static int[][] generate2DRandomArray(int m, int n, int inclusiveStart, int exclusiveEnd) {
        int[][] arr = new int[m][n];
        Random random = new Random();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = random.nextInt(exclusiveEnd - inclusiveStart) + inclusiveStart;
            }
        }
        return arr;
    }

    /**
     * Generates a 2D array of size m*n with given counter
     *
     * @param m the row
     * @param n the column
     * @return the 2D Array
     */
    public static int[][] generate2DSequentialArray(int m, int n, int startCounterInclusive) {
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = startCounterInclusive++;
            }
        }
        return arr;
    }

    public static char[][] generate2DSequentialCharArray(int m, int n, char startCounterInclusive) {
        char[][] arr = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = startCounterInclusive++;
            }
        }
        return arr;
    }
}
