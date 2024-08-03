package algo.practice.v2.daily_coding_problem;

import java.util.Arrays;

/**
 * The type P960
 *
 * @author nadeem Date : 07/03/24
 */
public class P960 {
    public static void main(String[] args) {
        P960 p960 = new P960();
        int[] arr = {2, 3, 0, 1, 4};
        boolean canReachEnd = p960.canReachEnd(arr);
        System.out.println(canReachEnd);

        int minJumpToEnd = p960.minJumpToEnd(arr);
        System.out.println("minJumpToEnd = " + minJumpToEnd);
    }

    public boolean canReachEnd(int[] arr) {
        int n = arr.length;
        boolean[] dp = new boolean[n];
        dp[0] = true;
        for (int i = 0; i < n - 1; i++) {
            if (dp[i]) {
                if (i + arr[i] >= n - 1) return true;
                for (int j = i + 1; j <= i + arr[i]; j++) {
                    dp[j] = true;
                }
            }
        }
        return dp[n - 1];
    }

    public int minJumpToEnd(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < n - 1; i++) {
            if (dp[i] == Integer.MAX_VALUE) continue;
            for (int j = i + 1; j < n && j <= i + arr[i]; j++) {
                dp[j] = Math.min(dp[j], dp[i] + 1);
            }
        }
        return dp[n - 1] == Integer.MAX_VALUE ? -1 : dp[n - 1];
    }
}
