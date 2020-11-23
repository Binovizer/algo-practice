package algo.interview.recursion.tube;

import java.util.ArrayList;
import java.util.List;

/**
 * This class helps generate all balanced parenthesis
 * Problem Desc : https://www.geeksforgeeks.org/print-all-combinations-of-balanced-parentheses/
 *
 * @author Nadeem 2020-11-22
 */
public class GenerateAllBalancedParenthesis {

    public static final String OPEN_BRACE = "(";
    public static final String CLOSE_BRACE = ")";

    private static List<String> balancedParenthesisList;

    public static void main(String[] args) {
        int n = 3;
        GenerateAllBalancedParenthesis generateAllBalancedParenthesis = new GenerateAllBalancedParenthesis();
        generateAllBalancedParenthesis.generate(n);
        System.out.println(balancedParenthesisList.size());
        System.out.println(balancedParenthesisList);
    }

    /**
     * Generates all balanced parenthesis of size n
     *
     * @param n the n
     */
    private void generate(int n) {
        balancedParenthesisList = new ArrayList<>();
        if (n == 0) {
            return;
        }
        if (n == 1) {
            balancedParenthesisList.add("()");
            return;
        }
        generate(n, n, "");
    }

    private void generate(int openCount, int closeCount, String output) {
        if (openCount == 0 && closeCount == 0) {
            balancedParenthesisList.add(output);
            return;
        }
        if (openCount != 0) {
            String op1 = output + OPEN_BRACE;
            generate(openCount - 1, closeCount, op1);
        }
        if (closeCount > openCount) {
            String op2 = output + CLOSE_BRACE;
            generate(openCount, closeCount - 1, op2);
        }
    }
}
