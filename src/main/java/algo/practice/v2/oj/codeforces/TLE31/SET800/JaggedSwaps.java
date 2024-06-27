package algo.practice.v2.oj.codeforces.TLE31.SET800;

import java.util.*;

/**
 * The type JaggedSwaps
 *
 * @author nadeem Date : 21/03/24
 */
public class JaggedSwaps {

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
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }

        if(arr[0] == 1) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
