package algo.practice.v2.oj.codeforces.TLE31.SET800;
import java.util.*;

/**
 * The type DontTryToCount
 *
 * @author nadeem Date : 22/03/24
 */
public class DontTryToCount {
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
        int m = in.nextInt();

        // Move to next line
        in.nextLine();

        StringBuilder x = new StringBuilder(in.nextLine());
        String s = in.nextLine();

        int ops = 0;
        while(true) {
            if(x.toString().contains(s)) {
                System.out.println(ops);
                return;
            }
            x.append(x);
            ops++;
            if(ops > 5) {
                System.out.println(-1);
                return;
            }
        }
    }
}
