package algo.practice.v2.platforms.interviewbit.math;

/**
 * https://www.interviewbit.com/problems/find-nth-fibonacci/
 *
 * @author Nadeem 2020-12-13
 */
public class NthFib {

    private int[] dp;

    public static void main(String[] args) {
        int A = 50;
        NthFib nthFib = new NthFib();
        int fib = nthFib.solve(A);
        System.out.println("fib = " + fib);
    }

    private int solve(int A) {
        //        dp = new int[10001];
        //        Arrays.fill(dp, -1);
        //        return nthFibMemo(A);
        return nthFibOptimized(A);
    }

    private int nthFib(int N) {
        if (N == 1 || N == 2) {
            return 1;
        }
        return nthFib(N - 1) + nthFib(N - 2);
    }

    private int nthFibMemo(int N) {
        if (N == 1 || N == 2) {
            return 1;
        }
        if (dp[N] != -1) {
            return dp[N];
        }
        int op1;
        if (dp[N - 1] != -1) {
            op1 = dp[N - 1];
        } else {
            op1 = nthFibMemo(N - 1) % 1000000007;
        }
        int op2;
        if (dp[N - 2] != -1) {
            op2 = dp[N - 2];
        } else {
            op2 = nthFibMemo(N - 2) % 1000000007;
        }
        return dp[N] = (op1 + op2) % 1000000007;
    }

    private int nthFibBottomUp(int N) {
        int[] dp = new int[N];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i] = (dp[i - 1] % 1000000007 + dp[i - 2] % 1000000007) % 1000000007;
        }
        return dp[N - 1];
    }

    private int nthFibOptimized(int N) {
        int secondLast = 1;
        int last = 1;
        int ans = 1;
        for (int i = 2; i < N; i++) {
            ans = (last + secondLast) % 1000000007;
            secondLast = last;
            last = ans;
        }
        return ans;
    }
}
