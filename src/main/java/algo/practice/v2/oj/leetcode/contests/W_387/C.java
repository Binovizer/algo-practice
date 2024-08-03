package algo.practice.v2.oj.leetcode.contests.W_387;


/**
 * The type A
 *
 * <p><a
 * href="https://leetcode.com/contest/weekly-contest-387/problems/minimum-operations-to-write-the-letter-y-on-a-grid/">Problem
 * Link</a>
 *
 * @author nadeem Date : 07/03/24
 */
public class C {
    int getOperationCount(int[][] grid, int y, int notY){
        int ans = 0, n = grid.length;
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < n; ++j){
                if((i <= n/2 && (i == j || i + j == n - 1)) || (i > n/2 && j == n/2)){
                    if(y != grid[i][j]) ans++;
                }else{
                    if(notY != grid[i][j]) ans++;
                }
            }
        }
        return ans;
    }

    public int minimumOperationsToWriteY(int[][] grid) {
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < 3; ++i){
            for(int j = 0; j < 3; ++j){
                if(i != j) ans = Math.min(ans, getOperationCount(grid, i,j));
            }
        }
        return ans;
    }
}
