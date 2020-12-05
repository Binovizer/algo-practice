package algo.interview.recursion.gfg;

import static algo.interview.utils.ArrayUtil.generate2DSequentialCharArray;
import static algo.interview.utils.ArrayUtil.print2DArray;

/**
 * This class helps find the number of paths from top left to bottom right of a MxN matrix with the
 * constraints that from each cell you can either move to right or down. Problem Description :
 * https://practice.geeksforgeeks.org/problems/number-of-paths0926/1/
 *
 * @author Nadeem 2020-11-23
 */
public class NumberOfPaths {

    public static void main(String[] args) {
        int m = 5; // <=10
        int n = 5; // <=10
        NumberOfPaths numberOfPaths = new NumberOfPaths();
        numberOfPaths.printPaths(m, n);
    }

    /**
     * Prints the possible paths from top left to bottom right
     *
     * @param m the m
     * @param n the n
     */
    private void printPaths(int m, int n) {
        char[][] arr = generate2DSequentialCharArray(m, n, 'A');
        print2DArray(arr);
        System.out.println("::: All possible paths from top left to bottom right :::");
        printPaths(m, n, 0, 0, arr, "");
    }

    /**
     * Prints the possible paths from top left to bottom right
     *
     * @param m the m
     * @param n the n
     * @param i the i
     * @param j the j
     * @param in the input
     * @param out the output
     */
    private void printPaths(int m, int n, int i, int j, char[][] in, String out) {
        if (i == m - 1 && j == n - 1) {
            System.out.println(out + in[i][j]);
            return;
        }
        if (i < m - 1) {
            String op1 = out + in[i][j];
            printPaths(m, n, i + 1, j, in, op1);
        }
        if (j < n - 1) {
            String op2 = out + in[i][j];
            printPaths(m, n, i, j + 1, in, op2);
        }
    }
}
