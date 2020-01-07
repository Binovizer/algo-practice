package algo.backtracking;

/**
 * The type Sudoku
 *
 * @author Mohd Nadeem
 */
public class Sudoku {

    private static void printMatrix(int[][] grid) {
        for (int[] ints : grid) {
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

    /**
     * Driver Program
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] grid =
                new int[][] {
                    {3, 0, 6, 5, 0, 8, 4, 0, 0},
                    {5, 2, 0, 0, 0, 0, 0, 0, 0},
                    {0, 8, 7, 0, 0, 0, 0, 3, 1},
                    {0, 0, 3, 0, 1, 0, 0, 8, 0},
                    {9, 0, 0, 8, 6, 3, 0, 0, 5},
                    {0, 5, 0, 0, 9, 0, 6, 0, 0},
                    {1, 3, 0, 0, 0, 0, 2, 5, 0},
                    {0, 0, 0, 0, 0, 0, 0, 7, 4},
                    {0, 0, 5, 2, 0, 6, 3, 0, 0}
                };
        printMatrix(grid);
        Sudoku sudoku = new Sudoku();
        sudoku.solve(grid);
    }

    public void solve(int[][] grid) {
        boolean solve = solve(grid, grid.length);
        if (solve) {
            System.out.println("Solution : ");
            printMatrix(grid);
        } else {
            System.out.println("Can't be solved.");
        }
    }

    private boolean solve(int[][] grid, int N) {
        if (solved(grid)) {
            return true;
        }
        for (int i = 1; i <= 9; i++) {
            int[] arr = getNextPosition(grid, N);
            int nextX = arr[0];
            int nextY = arr[1];
            if (isSafe(grid, nextX, nextY, i, N)) {
                grid[nextX][nextY] = i;
                if (solve(grid, N)) {
                    return true;
                }
                grid[nextX][nextY] = 0;
            }
        }
        return false;
    }

    private int[] getNextPosition(int[][] grid, int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 0) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[] {-1, -1};
    }

    private boolean isSafe(int[][] grid, int x, int y, int i, int N) {
        return rangeSafe(x, y, N)
                && rowSafe(grid, x, i, N)
                && columnSafe(grid, y, i, N)
                && gridSafe(grid, x, y, i, N);
    }

    private boolean gridSafe(int[][] grid, int x, int y, int element, int N) {
        int startX = (x / 3) * 3;
        int startY = (y / 3) * 3;
        for (int i = startX; i < startX + 3; i++) {
            for (int j = startY; j < startY + 3; j++) {
                if (grid[i][j] == element) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean columnSafe(int[][] grid, int col, int i, int N) {
        for (int j = 0; j < N; j++) {
            if (grid[j][col] == i) {
                return false;
            }
        }
        return true;
    }

    private boolean rowSafe(int[][] grid, int row, int i, int N) {
        for (int j = 0; j < N; j++) {
            if (grid[row][j] == i) {
                return false;
            }
        }
        return true;
    }

    private boolean rangeSafe(int x, int y, int N) {
        return (x >= 0 && y >= 0 && x < N && y < N);
    }

    private boolean solved(int[][] grid) {
        for (int[] ints : grid) {
            for (int anInt : ints) {
                if (anInt == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
