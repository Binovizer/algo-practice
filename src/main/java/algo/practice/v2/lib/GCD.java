package algo.practice.v2.lib;

/**
 * The type GCD
 *
 * @author nadeem Date : 31/07/21
 */
public class GCD {

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
