package algo.practice.v2.oj.codeforces.TLE31.SET900;

import java.util.*;

/**
 * The type P1869A
 *
 * @author nadeem Date : 29/03/24
 */
public class P1869A {
    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int t = in.nextInt();
        while (t-- > 0) {
            solve();
        }
        in.close();
    }

    private static void solve() {
        int n = in.nextInt(); // Size of the array
        ArrayList<Integer> a = new ArrayList<>(); // Use ArrayList for dynamic array
        for (int i = 0; i < n; i++) {
            a.add(in.nextInt()); // Read array elements
        }

        if ((n & 1) == 1) { // If n is odd
            System.out.println("4");
            System.out.println("1 " + (n - 1));
            System.out.println("1 " + (n - 1));
            System.out.println((n - 1) + " " + n);
            System.out.println((n - 1) + " " + n);
        } else { // If n is even
            System.out.println("2");
            System.out.println("1 " + n);
            System.out.println("1 " + n);
        }
    }
}
