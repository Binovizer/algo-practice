package algo.practice.v2.oj.codeforces.TLE31.SET800;

import java.util.*;

/**
 * The type P1833B
 *
 * @author nadeem Date : 26/03/24
 */
public class P1833B {

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
        int k = in.nextInt();
        in.nextLine();

        String str = in.nextLine();
        //        System.out.println(str);

        int[] freq = new int[26];
        for (char c : str.toCharArray()) {
            freq[c - 'a']++;
        }
        int oddCount = 0;
        for (int i = 0; i < 26; i++) {
            if ((freq[i] & 1) == 1) {
                oddCount++;
            }
        }
        if (oddCount > (k + 1)) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }
}
