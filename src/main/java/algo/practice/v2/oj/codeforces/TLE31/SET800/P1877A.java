package algo.practice.v2.oj.codeforces.TLE31.SET800;

import java.util.*;

/**
 * The type P1877A
 *
 * @author nadeem Date : 22/03/24
 */
public class P1877A {
    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int t = in.nextInt();
        while (t-- > 0) {
            solve();
        }
        in.close();
    }

    private static void solve() {
        int n = in.nextInt();
        int sum = 0;
        for (int i = 0; i < n - 1; i++) {
            sum += in.nextInt();
        }
        System.out.println(-1 * sum);
    }
}
