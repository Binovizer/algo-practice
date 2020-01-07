package algo.backtracking;

/**
 * The type NQueen
 *
 * @author Mohd Nadeem
 */
public class NQueen {

    private static int N = 8;
    private static int count = 0;
    private static int[][] chessboard = new int[N][N];

    private static void printMatrix() {
        for (int[] ints : chessboard) {
            for (int anInt : ints) {
                if (anInt < 10 && anInt > -10) {
                    System.out.print(" ");
                }
                if (anInt < 100 && anInt > -100) {
                    System.out.print(" ");
                }
                if (anInt >= 0) {
                    System.out.print(" ");
                }
                System.out.print(" " + anInt);
            }
            System.out.println();
        }
    }

    public void solve() {
        //        solve(0);
        //        printMatrix();
        solveAll(0);
    }

    private boolean solve(int col) {
        if (col >= N) {
            return true;
        }
        for (int k = 0; k < N; k++) {
            if (isSafe(k, col)) {
                chessboard[k][col] = 1;
                if (solve(col + 1)) {
                    return true;
                }
                chessboard[k][col] = 0;
            }
        }
        return false;
    }

    private void solveAll(int col) {
        if (col == N) {
            System.out.println("Solution # " + ++count);
            printMatrix();
            return;
        }
        for (int k = 0; k < N; k++) {
            if (isSafe(k, col)) {
                chessboard[k][col] = 1;
                solveAll(col + 1);
                chessboard[k][col] = 0;
            }
        }
    }

    private boolean isSafe(int k, int l) {
        if (!rangeSafe(k, l)) {
            return false;
        }
        if (!rowSafe(k, l)) {
            return false;
        }
        if (!columnSafe(k, l)) {
            return false;
        }
        return diagonalSafe(k, l);
    }

    private boolean diagonalSafe(int k, int l) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (((k + l == i + j) || (k - l == i - j)) && chessboard[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean columnSafe(int k, int l) {
        for (int i = 0; i < N; i++) {
            if (chessboard[k][i] == 1) {
                return false;
            }
        }
        return true;
    }

    private boolean rowSafe(int k, int l) {
        for (int i = 0; i < N; i++) {
            if (chessboard[i][l] == 1) {
                return false;
            }
        }
        return true;
    }

    private boolean rangeSafe(int k, int l) {
        return (k >= 0 && l >= 0 && k < N && l < N);
    }
}
