package algo.interview.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * This class helps generate n bit binary number having more 1’s than 0’s for any prefix
 * Problem Desc : https://practice.geeksforgeeks.org/problems/print-n-bit-binary-numbers-having-more-1s-than-0s0252/1
 *
 * @author Nadeem 2020-11-22
 */
public class NDigitBinaryNumber {

    private static List<String> numbers;

    public static void main(String[] args) {
        int n = 3;
        NDigitBinaryNumber nDigitBinaryNumber = new NDigitBinaryNumber();
        nDigitBinaryNumber.generate(n);
        System.out.println(numbers);
    }

    /**
     * Prints n bit binary number having more 1's than 0's in any prefix
     *
     * @param n the n
     */
    private void generate(int n) {
        numbers = new ArrayList<>();
        int onesUsed = 0;
        int zeroesUsed = 0;
        generate(onesUsed, zeroesUsed, n, "");
    }

    private void generate(int onesUsed, int zeroesUsed, int n, String output) {
        if (n == 0) {
            numbers.add(output);
            return;
        }
        String op1 = output + "1";
        generate(onesUsed + 1, zeroesUsed, n - 1, op1);
        if (onesUsed > zeroesUsed) {
            String op2 = output + "0";
            generate(onesUsed, zeroesUsed + 1, n - 1, op2);
        }
    }
}
