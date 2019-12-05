package backtracking;

/**
 * The type RatInMaze
 *
 * @author Mohd Nadeem
 */
public class RatInMaze {

    private static int count = 0;

    public void solve(int[][] maze){
        if(! solve(maze, 0, 0, maze.length)){
            System.out.println("Solution does not exist.");
            return;
        }
        System.out.println("Solution : ");
        printMatrix(maze);
    }

    private boolean solve(int[][] maze, int i, int j, int n) {
        if(maze[0][0] == -1 || maze[n-1][n-1] == -1 ){
            return false;
        }
        maze[i][j] = 1;
        if(i == n-1 && j == n-1){
            return true;
        }
        if(isSafe(maze, i+1, j, n)) {
            if (solve(maze, i + 1, j, n)) {
                return true;
            }
        }
        if(isSafe(maze, i, j+1, n)) {
            if(solve(maze, i, j+1, n)){
                return true;
            }
        }
        maze[i][j] = 0;
        return false;
    }

    private boolean isSafe(int[][] maze, int i, int j, int n) {
        return (i >= 0 && j >= 0 && i < n && j < n && maze[i][j] == 0);
    }

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
}
