package algo.practice.v2.oj.codeforces.TLE31.SET800;

import java.util.Scanner;

/**
 * The type CoverInWater
 *
 * @author nadeem Date : 21/03/24
 */
public class CoverInWater {

    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int t = in.nextInt();
        while (t-- > 0) {
            solve();
        }
        in.close();
    }

    private static void solve() {
        in.nextInt();
        in.nextLine();
        String str = in.nextLine();
        String subStr = "...";
        if (str.contains(subStr)) {
            System.out.println("2");
        } else {
            int count = 0;
            for (char c : str.toCharArray()) {
                if (c == '.') count++;
            }
            System.out.println(count);
        }
    }
}
