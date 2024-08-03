package algo.practice.v2.oj.leetcode.general;

/**
 * The type P_214
 *
 * <p><a href="https://leetcode.com/problems/shortest-palindrome/">Problem Link</a>
 *
 * @author nadeem Date : 09/05/24
 */
public class P_214 {

    public static void main(String[] args) {
        P_214 p214 = new P_214();
        String shortestPalindrome = p214.shortestPalindrome("aacecaaa");
        System.out.println("shortestPalindrome = " + shortestPalindrome);
    }

    public String shortestPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);

        if (checkPalindrome(sb)) return sb.toString();

        int n = s.length();
        for (int i = 1; i <= n; i++) {
            sb.insert(0, '*');
            System.out.println("Checking for palindrome : " + sb);
            if (checkPalindrome(sb)) {
                System.out.println("Getting Palindrome String");
                return getPalindromeString(sb);
            }
        }
        return null;
    }

    private String getPalindromeString(StringBuilder sb) {
        int n = sb.length();

        int i = 0;
        while (i < n / 2) {
            char frontChar = sb.charAt(i);
            char backChar = sb.charAt(n - i - 1);

            if (frontChar == '*') {
                sb.setCharAt(i, backChar);
                i++;
            } else {
                break;
            }
        }
        return sb.toString();
    }

    private boolean checkPalindrome(StringBuilder sb) {
        int n = sb.length();
        int i = 0;
        while (i < n / 2) {
            char frontChar = sb.charAt(i);
            char backChar = sb.charAt(n - i - 1);
            if (frontChar == '*' || frontChar == backChar) {
                i++;
            } else {
                return false;
            }
        }
        return true;
    }
}
