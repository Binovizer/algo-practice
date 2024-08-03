package algo.practice.v2.oj.leetcode.practice.grind169;

/**
 * The type P_542
 *
 * @author nadeem Date : 26/07/24
 */
public class P_542 {

    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((i == 0 && j == 0) || mat[i][j] == 0) continue;
                if (i == 0) {
                    mat[i][j] = mat[i][j - 1] + 1;
                } else if (j == 0) {
                    mat[i][j] = mat[i - 1][j] + 1;
                } else {
                    mat[i][j] = 1 + Math.min(mat[i - 1][j], mat[i][j - 1]);
                }
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if ((i == n - 1 && j == m - 1) || mat[i][j] == 0) continue;
                if (i == n - 1) {
                    mat[i][j] = Math.min(mat[i][j], 1 + mat[i][j + 1] + 1);
                } else if (j == m - 1) {
                    mat[i][j] = Math.min(mat[i][j], 1 + mat[i + 1][j] + 1);
                } else {
                    mat[i][j] = Math.min(mat[i][j], 1 + Math.min(mat[i + 1][j], mat[i][j + 1]));
                }
            }
        }

        return mat;
    }
}
