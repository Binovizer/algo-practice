package algo.practice.v2.oj.codeforces.TLE31.SET900;

import java.util.*;

/**
 * The type P1878C
 *
 * @author nadeem Date : 26/03/24
 */
public class P1878C {
    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int t = in.nextInt();
        while (t-- > 0) {
            solve();
        }
        in.close();
    }

    private static void solve() {
        long n = in.nextLong();
        long x = in.nextLong();
        long k = in.nextLong();

        // Check if k is between the minimum and maximum sum
        if (2 * k >= x * (x + 1) && 2 * k <= n * (n + 1) - (n - x) * (n - x + 1)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
