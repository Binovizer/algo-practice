package algo.interview.dp.tube;

import java.util.HashMap;
import java.util.Map;

/**
 * Evaluate Expression to True
 *
 * @author Nadeem 2020-12-07
 */
public class EvaluateExprToTrue {

    private Map<String, Integer> dp;

    public static void main(String[] args) {
        String expr = "T^F&T";
        EvaluateExprToTrue evaluateExprToTrue = new EvaluateExprToTrue();
        int expressions = evaluateExprToTrue.evaluate(expr);
        System.out.println("expressions = " + expressions);
    }

    private int evaluate(String expr) {
        dp = new HashMap<>();
        return solveMemo(expr.toCharArray(), 0, expr.length() - 1, 'T');
    }

    private int solve(char[] arr, int i, int j, char expected) {
        if (i > j) {
            return 0;
        }
        if (i == j) {
            if (arr[i] == expected) {
                return 1;
            } else {
                return 0;
            }
        }
        int noOfWays = 0;
        for (int k = i + 1; k <= j - 1; k = k + 2) {
            int leftTrue = solve(arr, i, k - 1, 'T');
            int leftFalse = solve(arr, i, k - 1, 'F');
            int rightTrue = solve(arr, k + 1, j, 'T');
            int rightFalse = solve(arr, k + 1, j, 'F');
            if (arr[k] == '&') {
                if (expected == 'T') {
                    noOfWays += (leftTrue * rightTrue);
                } else {
                    noOfWays +=
                            (leftFalse * rightFalse
                                    + leftFalse * rightTrue
                                    + leftTrue * rightFalse);
                }
            } else if (arr[k] == '|') {
                if (expected == 'T') {
                    noOfWays +=
                            (leftFalse * rightTrue + leftTrue * rightTrue + leftTrue * rightFalse);
                } else {
                    noOfWays += (leftFalse * rightFalse);
                }
            } else {
                if (expected == 'T') {
                    noOfWays += (leftFalse * rightTrue + leftTrue * rightFalse);
                } else {
                    noOfWays += (leftFalse * rightFalse + leftTrue * rightTrue);
                }
            }
        }
        return noOfWays;
    }

    private int solveMemo(char[] arr, int i, int j, char expected) {
        if (i > j) {
            dp.put(KeyGenerator.generateKey(i, j, expected), 0);
        }
        if (i == j) {
            if (arr[i] == expected) {
                dp.put(KeyGenerator.generateKey(i, j, expected), 1);
            } else {
                dp.put(KeyGenerator.generateKey(i, j, expected), 0);
            }
        }
        if (dp.containsKey(KeyGenerator.generateKey(i, j, expected))) {
            return dp.get(KeyGenerator.generateKey(i, j, expected));
        }
        int noOfWays = 0;
        for (int k = i + 1; k <= j - 1; k = k + 2) {
            int leftTrue;
            if (dp.containsKey(KeyGenerator.generateKey(i, k - 1, 'T'))) {
                leftTrue = dp.get(KeyGenerator.generateKey(i, k - 1, 'T'));
            } else {
                leftTrue = solveMemo(arr, i, k - 1, 'T');
            }
            dp.put(KeyGenerator.generateKey(i, k - 1, 'T'), leftTrue);

            int leftFalse;
            if (dp.containsKey(KeyGenerator.generateKey(i, k - 1, 'F'))) {
                leftFalse = dp.get(KeyGenerator.generateKey(i, k - 1, 'F'));
            } else {
                leftFalse = solveMemo(arr, i, k - 1, 'F');
            }
            dp.put(KeyGenerator.generateKey(i, k - 1, 'F'), leftFalse);

            int rightTrue;
            if (dp.containsKey(KeyGenerator.generateKey(k + 1, j, 'T'))) {
                rightTrue = dp.get(KeyGenerator.generateKey(k + 1, j, 'T'));
            } else {
                rightTrue = solveMemo(arr, k + 1, j, 'T');
            }
            dp.put(KeyGenerator.generateKey(k + 1, j, 'T'), rightTrue);

            int rightFalse;
            if (dp.containsKey(KeyGenerator.generateKey(k + 1, j, 'F'))) {
                rightFalse = dp.get(KeyGenerator.generateKey(k + 1, j, 'F'));
            } else {
                rightFalse = solveMemo(arr, k + 1, j, 'F');
            }
            dp.put(KeyGenerator.generateKey(k + 1, j, 'F'), rightFalse);

            if (arr[k] == '&') {
                if (expected == 'T') {
                    noOfWays += (leftTrue * rightTrue);
                } else {
                    noOfWays +=
                            (leftFalse * rightFalse
                                    + leftFalse * rightTrue
                                    + leftTrue * rightFalse);
                }
            } else if (arr[k] == '|') {
                if (expected == 'T') {
                    noOfWays +=
                            (leftFalse * rightTrue + leftTrue * rightTrue + leftTrue * rightFalse);
                } else {
                    noOfWays += (leftFalse * rightFalse);
                }
            } else {
                if (expected == 'T') {
                    noOfWays += (leftFalse * rightTrue + leftTrue * rightFalse);
                } else {
                    noOfWays += (leftFalse * rightFalse + leftTrue * rightTrue);
                }
            }
        }
        return noOfWays;
    }

    public static class KeyGenerator {
        public static String generateKey(int i, int j, char expected) {
            return i + " " + j + " " + expected;
        }
    }
}
