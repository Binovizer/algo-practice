package algo.practice.v2.platforms.leetcode.challenges.dec.week1;

import algo.practice.v2.utils.ArrayUtil;

/**
 * This is the description of what this type does
 *
 * @author Nadeem 2020-12-07
 */
public class SpiralMatrixII {

    public static void main(String[] args) {
        int n = 4;
        SpiralMatrixII spiralMatrixII = new SpiralMatrixII();
        int[][] mat = spiralMatrixII.generateMatrix(n);
        ArrayUtil.print2DArray(mat);
    }

    private int[][] generateMatrix(int n) {
        int[][] mat = new int[n][n];
        int counter = 1;
        int topRow = 0;
        int rightCol = n - 1;
        int bottomRow = n - 1;
        int leftCol = 0;
        while (topRow <= bottomRow) {
            // print left to right
            for (int i = leftCol; i <= rightCol; i++) {
                mat[topRow][i] = counter++;
            }
            topRow++;
            // print top to bottom
            for (int i = topRow; i <= bottomRow; i++) {
                mat[i][rightCol] = counter++;
            }
            rightCol--;
            // print right to left
            for (int i = rightCol; i >= leftCol; i--) {
                mat[bottomRow][i] = counter++;
            }
            bottomRow--;
            // print bottom to top
            for (int i = bottomRow; i >= topRow; i--) {
                mat[i][leftCol] = counter++;
            }
            leftCol++;
        }
        return mat;
    }
}
