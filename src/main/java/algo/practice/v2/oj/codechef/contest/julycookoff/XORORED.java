package algo.practice.v2.oj.codechef.contest.julycookoff;

import java.util.Arrays;
import java.util.Scanner;

/**
 * The type XORORED
 *
 * @author nadeem Date : 28/07/21
 */
public class XORORED {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            boolean[] bitset = new boolean[32];
            for (int i = 0; i < 32; i++) {
                for (int j = 0; j < n; j++) {
                    if ((a[j] & (1 << i)) != 0) {
                        bitset[32 - i - 1] = true;
                        break;
                    }
                }
            }
            System.out.println(Arrays.toString(bitset));
            // 0 1 1
            int ans = 0;
            int step = 1;
            for (int i = 31; i >= 0; i--) {
                if (bitset[i]) {
                    ans = ans + step;
                }
                step *= 2;
            }
            System.out.println(ans);
        }
        in.close();
    }
}
