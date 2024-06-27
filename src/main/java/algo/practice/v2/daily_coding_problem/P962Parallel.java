package algo.practice.v2.daily_coding_problem;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/** The type P962 modified for parallel execution. */
public class P962Parallel {

    int[][] moves =
            new int[][] {
                {-2, +1}, {-2, -1},
                {+2, +1}, {+2, -1},
                {-1, +2}, {+1, +2},
                {-1, -2}, {+1, -2}
            };

    public static void main(String[] args) {
        P962Parallel p962 = new P962Parallel();
        long noOfKnightTours = p962.noOfKnightToursParallel(6);
        System.out.println("noOfKnightTours = " + noOfKnightTours);
    }

    public long noOfKnightToursParallel(int n) {
        ExecutorService executor =
                Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        List<Callable<Long>> tasks = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                final int startI = i;
                final int startJ = j;
                tasks.add(
                        () -> {
                            boolean[][] visited = new boolean[n][n];
                            visited[startI][startJ] = true;
                            return noOfKnightTours(startI, startJ, 1, n, visited);
                        });
            }
        }

        long ans = 0;
        try {
            List<Future<Long>> results = executor.invokeAll(tasks);
            for (Future<Long> result : results) {
                ans += result.get();
            }
        } catch (Exception ignore) {
        }

        executor.shutdown();
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
