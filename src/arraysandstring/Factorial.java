package arraysandstring;

import java.math.BigInteger;

/**
 * The type Factorial
 *
 * @author Mohd Nadeem
 */
public class Factorial {

    public static void main(String[] args) {
        Factorial factorial = new Factorial();
        String ans = factorial.factorial(100);
        String ans2 = factorial.factorialWithBigInteger(100);
        System.out.println("ans = " + ans);
        System.out.println("ans2 = " + ans2);
    }

    public String factorialWithBigInteger(int n) {
        BigInteger ans = new BigInteger("1");
        int i = 2;
        while (i < n) {
            ans = ans.multiply(new BigInteger(String.valueOf(i)));
            i++;
        }
        return ans.toString();
    }

    public String factorial(int n) {
        String ans = "1";
        int i = 2;
        while (i < n) {
            ans = Multiply.multiply(ans, String.valueOf(i));
            i++;
        }
        return ans;
    }
}
