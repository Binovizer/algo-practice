package algo.practice.v2.oj.codeforces.TLE31.SET800;

import java.util.*;

/**
 * The type P1866A
 *
 * @author nadeem Date : 22/03/24
 */
public class P1866A {
    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        //        int t = in.nextInt();
        int t = 1;
        while (t-- > 0) {
            solve();
        }
        in.close();
    }

    private static void solve() {
        int n = in.nextInt();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            min = Math.min(min, Math.abs(num));
        }
        System.out.println(min);
    }
}
