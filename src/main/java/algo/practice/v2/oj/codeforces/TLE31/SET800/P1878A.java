package algo.practice.v2.oj.codeforces.TLE31.SET800;

import java.util.*;

/**
 * The type P1878A
 *
 * @author nadeem Date : 22/03/24
 */
public class P1878A {
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
        int k = in.nextInt();

        boolean found = false;
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            if (num == k) {
                found = true;
            }
        }
        if (found) System.out.println("YES");
        else System.out.println("NO");
    }
}
