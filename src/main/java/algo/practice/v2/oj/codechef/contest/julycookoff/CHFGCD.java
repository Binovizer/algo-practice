package algo.practice.v2.oj.codechef.contest.julycookoff;

import java.util.Scanner;

/**
 * The type CHFGCD
 *
 * @author nadeem Date : 28/07/21
 */
public class CHFGCD {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int x = in.nextInt();
            int y = in.nextInt();
            int gcd = gcd(x, y);
            if (gcd > 1) {
                System.out.println(0);
            } else if (gcd(x + 1, y) > 1 || gcd(x, y + 1) > 1) {
                System.out.println(1);
            } else {
                System.out.println(2);
            }
        }
        in.close();
    }

    public static int gcd(int a, int b) {
        if (a == -1) {
            return b;
        }
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
