package algo.practice.v2.oj.codeforces.TLE31.SET800;

import java.util.Scanner;

/**
 * The type GameWithIntegers
 *
 * @author nadeem Date : 21/03/24
 */
public class GameWithIntegers {

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
        if (n % 3 == 0) System.out.println("Second");
        else System.out.println("First");
    }
}
