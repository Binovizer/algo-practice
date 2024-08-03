package algo.practice.v2.oj.codeforces.TLE31.SET900;

import java.util.*;

/**
 * The type P1904A
 *
 * @author nadeem Date : 22/03/24
 */
public class P1904A {
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
        int x1 = in.nextInt();
        int y1 = in.nextInt();
        int x2 = in.nextInt();
        int y2 = in.nextInt();

        Set<Pair> st1 = new HashSet<>();
        Set<Pair> st2 = new HashSet<>();
        int[] dx = {-1, 1, -1, 1};
        int[] dy = {-1, -1, 1, 1};

        for (int j = 0; j < 4; j++) {
            st1.add(new Pair(x1 + dx[j] * a, y1 + dy[j] * b));
            st2.add(new Pair(x2 + dx[j] * a, y2 + dy[j] * b));
            st1.add(new Pair(x1 + dx[j] * b, y1 + dy[j] * a));
            st2.add(new Pair(x2 + dx[j] * b, y2 + dy[j] * a));
        }

        int ans = 0;
        for (Pair x : st1) if (st2.contains(x)) ans++;
        System.out.println(ans);
    }

    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }

        @Override
        public int hashCode() {
            return 31 * x + y;
        }
    }
}
