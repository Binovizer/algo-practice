package algo.practice.v2.paradigms.dp.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/decode-ways/
 *
 * @author Nadeem 2020-12-11
 */
public class DecodeWays {

    private Map<String, Integer> dp;

    {
        dp = new HashMap<>();
    }

    public static void main(String[] args) {
        String str = "226";
        DecodeWays decodeWays = new DecodeWays();
        int noOfWays = decodeWays.noOfWaysBottomUp(str);
        System.out.println("noOfWays = " + noOfWays);
    }

    private int noOfWays(String str) {
        if (str.startsWith("0")) {
            return 0;
        }
        if (str.length() == 0 || str.length() == 1) {
            return 1;
        }
        int op1 = noOfWays(str.substring(1));
        int op2 = 0;
        int num = Integer.parseInt(str.substring(0, 2));
        if (num <= 26) {
            op2 = noOfWays(str.substring(2));
        }
        return op1 + op2;
    }

    private int noOfWaysMemo(String str) {
        if (str.startsWith("0")) {
            return 0;
        }
        if (str.length() == 0 || str.length() == 1) {
            return 1;
        }
        if (dp.containsKey(str)) {
            return dp.get(str);
        }
        String in1 = str.substring(1);
        int op1 = noOfWaysMemo(in1);
        int num = Integer.parseInt(str.substring(0, 2));
        int op2 = 0;
        if (num <= 26) {
            String in2 = str.substring(2);
            op2 = noOfWaysMemo(in2);
        }
        int op = op1 + op2;
        dp.put(str, op);
        return op;
    }

    private int noOfWaysBottomUp(String str) {
        if (str.length() == 0) {
            return 0;
        }
        int n = str.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = str.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= n; i++) {
            int first = Integer.parseInt(str.substring(i - 1, i)); // first char
            int second = Integer.parseInt(str.substring(i - 2, i)); // first 2 char
            if (first >= 1 && first <= 9) {
                dp[i] += dp[i - 1];
            }
            if (second >= 10 && second <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }
}
