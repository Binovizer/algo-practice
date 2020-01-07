package algo.backtracking;
/**
 * The type KnightsTour
 *
 * @author Mohd Nadeem
 */
public class KnightsTour {

    private static final int[] X = {2, 1, -1, -2, -2, -1, 1, 2};
    private static final int[] Y = {1, 2, 2, 1, -1, -2, -2, -1};
    private static final int N = 5;
    private static final int[][] chessBoard = new int[N][N];
    private static int SOL = 0;

    private static void printMatrix() {
        for (int[] ints : KnightsTour.chessBoard) {
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
        solve(0, 0, 1);
        //        solveAll(0, 0, 1);
    }

    private boolean solve(int x, int y, int move) {
        if (move == N * N) {
            printMatrix();
            return true;
        }
        for (int i = 0; i < 8; i++) {
            int nextX = x + X[i];
            int nextY = y + Y[i];
            if (isSafe(nextX, nextY)) {
                chessBoard[nextX][nextY] = move;
                if (solve(nextX, nextY, move + 1)) {
                    return true;
                }
                chessBoard[nextX][nextY] = 0;
            }
        }
        return false;
    }

    private void solveAll(int x, int y, int move) {
        chessBoard[x][y] = move;
        if (move >= N * N) {
            System.out.println("Solution # " + ++SOL);
            printMatrix();
            System.out.println();
            System.out.println();
            chessBoard[x][y] = 0;
            return;
        }
        for (int i = 0; i < 8; i++) {
            int nextX = x + X[i];
            int nextY = y + Y[i];
            if (isSafe(nextX, nextY)) {
                solveAll(nextX, nextY, move + 1);
            }
        }
        chessBoard[x][y] = 0;
    }

    private boolean isSafe(int x, int y) {
        return (x >= 0 && y >= 0 && x < N && y < N && chessBoard[x][y] == 0);
    }
}
