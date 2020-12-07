package algo.interview.dp.tube;

import java.util.HashMap;
import java.util.Map;

/**
 * This is the description of what this type does
 *
 * @author Nadeem 2020-12-07
 */
public class ScrambledString {

    private Map<String, Boolean> dp;

    public static void main(String[] args) {
        String A = "coder";
        String B = "ocder";
        ScrambledString scrambledString = new ScrambledString();
        boolean isScrambled = scrambledString.isScrambled(A, B);
        System.out.println("isScrambled = " + isScrambled);
    }

    private boolean isScrambled(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }
        dp = new HashMap<>();
        return solveMemo(A, B);
    }

    private boolean solve(String A, String B) {
        if (A.equals(B)) {
            return true;
        }
        if (A.length() <= 1) {
            return false;
        }
        int n = A.length();
        for (int i = 1; i <= n - 1; i++) {
            String aFirst = A.substring(0, i);
            String aLast = A.substring(i, n);
            String bFirst = B.substring(0, i);
            String bLast = B.substring(i, n);
            // Without swap -> (A.first isScrambled B.first) && (A.last isScrambled B.last)
            boolean condition1 = solve(aFirst, bFirst) && solve(aLast, bLast);
            if(condition1){
                return true;
            }
            // With swap -> (A.first isScrambled B.last) && (A.last isScrambled B.first)
            aFirst = A.substring(0, n - i);
            aLast = A.substring(n - i, n);
            boolean condition2 = solve(aFirst, bLast) && solve(aLast, bFirst);
            if (condition2) {
                return true;
            }
        }
        return false;
    }

    private boolean solveMemo(String A, String B) {
        if (A.equals(B)) {
            return true;
        }
        if (A.length() <= 1) {
            return false;
        }
        if (dp.containsKey(KeyGenerator.generateKey(A, B))) {
            return dp.get(KeyGenerator.generateKey(A, B));
        }
        int n = A.length();
        for (int i = 1; i <= n - 1; i++) {
            String aFirst = A.substring(0, i);
            String aLast = A.substring(i, n);
            String bFirst = B.substring(0, i);
            String bLast = B.substring(i, n);
            // Without swap -> (A.first isScrambled B.first) && (A.last isScrambled B.last)
            boolean part11;
            if (dp.containsKey(KeyGenerator.generateKey(aFirst, bFirst))) {
                part11 = dp.get(KeyGenerator.generateKey(aFirst, bFirst));
            } else {
                part11 = solveMemo(aFirst, bFirst);
            }
            dp.put(KeyGenerator.generateKey(aFirst, bFirst), part11);

            boolean part12;
            if (dp.containsKey(KeyGenerator.generateKey(aLast, bLast))) {
                part12 = dp.get(KeyGenerator.generateKey(aLast, bLast));
            } else {
                part12 = solveMemo(aLast, bLast);
            }
            dp.put(KeyGenerator.generateKey(aLast, bLast), part12);

            boolean condition1 = part11 && part12;
            if (condition1) {
                return true;
            }

            // With swap -> (A.first isScrambled B.last) && (A.last isScrambled B.first)
            aFirst = A.substring(0, n - i);
            aLast = A.substring(n - i, n);
            boolean part21;
            if (dp.containsKey(KeyGenerator.generateKey(aFirst, bLast))) {
                part21 = dp.get(KeyGenerator.generateKey(aFirst, bLast));
            } else {
                part21 = solveMemo(aFirst, bLast);
            }
            dp.put(KeyGenerator.generateKey(aFirst, bLast), part21);

            boolean part22;
            if (dp.containsKey(KeyGenerator.generateKey(aLast, bFirst))) {
                part22 = dp.get(KeyGenerator.generateKey(aLast, bFirst));
            } else {
                part22 = solveMemo(aLast, bFirst);
            }
            dp.put(KeyGenerator.generateKey(aLast, bFirst), part22);

            boolean condition2 = part21 && part22;
            if (condition2) {
                return true;
            }
        }
        return false;
    }

    public static class KeyGenerator {
        public static String generateKey(String A, String B) {
            return "A : " + A + " B : " + B;
        }
    }
}
