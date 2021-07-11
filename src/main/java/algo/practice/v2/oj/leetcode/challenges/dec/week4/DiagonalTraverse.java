package algo.practice.v2.oj.leetcode.challenges.dec.week4;

import algo.practice.v2.utils.ArrayUtil;

import java.util.Arrays;

/** @author Nadeem 2020-12-26 */
public class DiagonalTraverse {

    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        int[][] matrix = ArrayUtil.generate2DSequentialArray(m, n, 1);
        DiagonalTraverse diagonalTraverse = new DiagonalTraverse();
        int[] diagonalOrder = diagonalTraverse.findDiagonalOrder(matrix);
        System.out.println("diagonalOrder = " + Arrays.toString(diagonalOrder));
    }

    public int[] findDiagonalOrder(int[][] matrix) {
        int H = matrix.length;
        if (H == 0) {
            return new int[] {};
        }
        int W = matrix[0].length;
        int[] out = new int[H * W];
        int index = 0;
        boolean bottomToUp = true;
        int iStart = 0;
        int jStart = 0;
        int iEnd = 0;
        int jEnd = 0;
        while (iStart < H && jStart < W) {
            if (bottomToUp) {
                int i = iEnd;
                int j = jStart;
                while (i >= iStart && j <= jEnd) {
                    out[index++] = matrix[i][j];
                    i--;
                    j++;
                }
            } else {
                int i = iStart;
                int j = jEnd;
                while (i <= iEnd && j >= jStart) {
                    out[index++] = matrix[i][j];
                    i++;
                    j--;
                }
            }
            if (iEnd == H - 1) {
                jStart++;
            } else {
                iEnd++;
            }
            if (jEnd == W - 1) {
                iStart++;
            } else {
                jEnd++;
            }
            bottomToUp = !bottomToUp;
        }
        return out;
    }
}
