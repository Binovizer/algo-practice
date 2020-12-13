package algo.practice.v2.utils;

import java.util.Arrays;
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
                System.out.printf("%3d", anInt);
            }
            System.out.println();
        }
    }

    /**
     * Prints the given 2D array
     *
     * @param arr the array
     */
    public static void print2DArray(boolean[][] arr) {
        System.out.println("::: Array :::");
        for (boolean[] bools : arr) {
            for (boolean aBool : bools) {
                if (aBool) System.out.printf("%3c ", 'T');
                else System.out.printf("%3c ", 'F');
            }
            System.out.println();
        }
    }

    /**
     * Prints the given array
     *
     * @param arr the array
     */
    public static void printArray(int[] arr) {
        System.out.println("::: Array :::");
        for (int anInt : arr) {
            System.out.print(anInt + " ");
        }
        System.out.println();
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
    public static int[][] generate2DRandomArray(
            int m, int n, int inclusiveStart, int exclusiveEnd) {
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
     * Generates a 2D array of size m*n with given range
     *
     * @param size the size
     * @param inclusiveStart the inclusive start of range
     * @param exclusiveEnd the exclusive end of range
     * @return the Array
     */
    public static int[] generateRandomArray(int size, int inclusiveStart, int exclusiveEnd) {
        int[] arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(exclusiveEnd - inclusiveStart) + inclusiveStart;
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

    /**
     * Generates a array of given size with given counter
     *
     * @param size the size
     * @return the 2D Array
     */
    public static int[] generateSequentialArray(int size, int startCounterInclusive) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = startCounterInclusive++;
        }
        return arr;
    }

    /**
     * Generates 2D Sequential Array
     *
     * @param m the m
     * @param n the n
     * @param startCounterInclusive the start counter
     * @return the char array
     */
    public static char[][] generate2DSequentialCharArray(int m, int n, char startCounterInclusive) {
        char[][] arr = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = startCounterInclusive++;
            }
        }
        return arr;
    }

    /**
     * Fills 2D Array with the given value
     *
     * @param array the array
     * @param val the val
     */
    public static void fill2DArray(int[][] array, int val) {
        for (int[] arr : array) {
            Arrays.fill(arr, val);
        }
    }

    /**
     * Fills 3D Array with the given value
     *
     * @param array the array
     * @param val the val
     */
    public static void fill3DArray(int[][][] array, int val) {
        for (int[][] twoDArr : array) {
            for (int[] arr : twoDArr) {
                Arrays.fill(arr, val);
            }
        }
    }
}
