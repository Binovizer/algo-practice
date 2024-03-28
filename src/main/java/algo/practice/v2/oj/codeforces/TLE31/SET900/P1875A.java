package algo.practice.v2.oj.codeforces.TLE31.SET900;

import java.util.*;

/**
 * The type P1875A
 *
 * @author nadeem Date : 29/03/24
 */
public class P1875A {
    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int t = in.nextInt();
        while (t-- > 0) {
            solve();
        }
        in.close();
    }

    private static void solve() {
        int a = in.nextInt();
        int b = in.nextInt();
        int n = in.nextInt();

        long sum = b;
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            sum += Math.min(x, a - 1);
        }
        System.out.println(sum);
    }
}
