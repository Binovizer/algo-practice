package algo.practice.v2.daily_coding_problem;

/**
 * The type P962
 *
 * @author nadeem Date : 14/03/24
 */
public class P962 {
    public static void main(String[] args) {
        P962 p962 = new P962();
        long noOfKnightTours = p962.noOfKnightTours(5);
        System.out.println("noOfKnightTours = " + noOfKnightTours);
    }

    int[][] moves =
            new int[][] {
                {-2, +1}, {-2, -1}, // Up movements
                {+2, +1}, {+2, -1}, // Down movements
                {-1, +2}, {+1, +2}, // Right movements
                {-1, -2}, {+1, -2} // Left movements
            };

    public long noOfKnightTours(int n) {
        boolean[][] visited = new boolean[n][n];

        long ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = true;
                ans += noOfKnightTours(i, j, 1, n, visited);
                visited[i][j] = false;
            }
        }
        return ans;
    }

    private long noOfKnightTours(int i, int j, int moveNo, int n, boolean[][] visited) {
        if (moveNo == n * n) return 1;
        long sumOfMoves = 0;
        for (int[] move : moves) {
            if (validMove(i, j, move, n, visited)) {
                int newI = i + move[0];
                int newJ = j + move[1];
                visited[newI][newJ] = true;
                sumOfMoves += noOfKnightTours(newI, newJ, moveNo + 1, n, visited);
                visited[newI][newJ] = false;
            }
        }
        return sumOfMoves;
    }

    private boolean validMove(int i, int j, int[] move, int n, boolean[][] visited) {
        int newI = i + move[0];
        int newJ = j + move[1];
        return newI >= 0 && newI < n && newJ >= 0 && newJ < n && !visited[newI][newJ];
    }
}
