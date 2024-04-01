package algo.practice.v2.oj.leetcode.contests.BW_127;

/**
 * The type B
 *
 * @author nadeem Date : 02/04/24
 */
public class B {
    public int minimumLevels(int[] possible) {
        int n = possible.length;
        int[] d = new int[n + 1];
        d[0] = 0;
        for (int i = 0; i < n; i++) {
            d[i + 1] = d[i] + (possible[i] == 0 ? -1 : 1);
        }
        // System.out.println(Arrays.toString(d));
        int[] b = new int[n + 1];
        b[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            b[i] = b[i + 1] + (possible[i] == 0 ? -1 : 1);
        }
        // System.out.println(Arrays.toString(b));
        for (int i = 1; i < n; i++) {
            if (d[i] > b[i]) {
                return i;
            }
        }
        return -1;
    }
}
