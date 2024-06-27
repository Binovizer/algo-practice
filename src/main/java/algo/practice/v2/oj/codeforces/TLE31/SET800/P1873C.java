package algo.practice.v2.oj.codeforces.TLE31.SET800;

import java.util.*;

/**
 * The type P1873C
 *
 * @author nadeem Date : 22/03/24
 */
public class P1873C {
    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int t = in.nextInt();
        in.nextLine();
        while (t-- > 0) {
            solve();
        }
        in.close();
    }

    private static void solve() {
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            String row = in.nextLine();
            for (int j = 0; j < 10; j++) {
                char c = row.charAt(j);
                if (c == 'X') {
                    int x = Math.min(i, 9 - i);
                    int y = Math.min(j, 9 - j);
                    int score = Math.min(x, y) + 1;
                    sum += score;
                }
            }
        }
        System.out.println(sum);
    }
}
