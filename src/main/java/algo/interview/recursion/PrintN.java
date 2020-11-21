package algo.interview.recursion;

/**
 * This class prints number from 1 to N
 *
 * @author Nadeem 2020-10-25
 */
public class PrintN {

    public static void main(String[] args) {
        int n = 7;
        PrintN printN = new PrintN();
        printN.printReverse(7);
    }

    /**
     * Prints number in the range of 1 to n
     *
     * @param n the n
     */
    private void print(int n) {
        if (n == 1) {
            System.out.println(n);
            return;
        }
        print(n - 1);
        System.out.println(n);
    }

    /**
     * Prints number in the range of n to 1
     *
     * @param n the n
     */
    private void printReverse(int n) {
        if (n == 1) {
            System.out.println(n);
            return;
        }
        System.out.println(n);
        printReverse(n - 1);
    }
}
