package backtracking;

/**
 * The type MazeSolutions
 *
 * @author Mohd Nadeem
 */
public class MazeSolutions {

    private static int count = 1;

    private static void printMatrix(int[][] maze) {
        for (int[] ints : maze) {
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

    public int count(int[][] maze) {
        solve(maze, 0, 0, maze.length);
        return count;
    }

    private void solve(int[][] maze, int i, int j, int n) {
        maze[i][j] = 1;
        if (i == n - 1 && j == n - 1) {
            System.out.println("Solution # " + count);
            printMatrix(maze);
            System.out.println();
            count++;
            maze[i][j] = 0;
            return;
        }
        if (isSafe(maze, i + 1, j, n)) {
            solve(maze, i + 1, j, n);
        }
        if (isSafe(maze, i, j + 1, n)) {
            solve(maze, i, j + 1, n);
        }
        maze[i][j] = 0;
    }

    private boolean isSafe(int[][] maze, int i, int j, int n) {
        return i >= 0 && j >= 0 && i < n && j < n && maze[i][j] == 0;
    }
}
