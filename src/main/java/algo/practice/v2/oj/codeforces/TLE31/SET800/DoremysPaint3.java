package algo.practice.v2.oj.codeforces.TLE31.SET800;

import java.util.*;

/**
 * The type DoremysPaint3
 *
 * @author nadeem Date : 22/03/24
 */
public class DoremysPaint3 {
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
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            freq.put(a, freq.getOrDefault(a, 0) + 1);
        }
        if (n == 2) {
            System.out.println("Yes");
            return;
        }
//        System.out.println(freq);
        if (freq.size() == 1) {
            System.out.println("Yes");
        } else if (freq.size() > 2) {
            System.out.println("No");
        } else {
            int sum = 0;
            boolean positive = true;
            for (int key : freq.keySet()) {
                if (positive) sum += freq.get(key);
                else sum -= freq.get(key);
                positive = false;
            }
            if (Math.abs(sum) == 1 || Math.abs(sum) == 0) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}
