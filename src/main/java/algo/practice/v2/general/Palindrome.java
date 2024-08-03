package algo.practice.v2.general;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * The type Palindrome
 *
 * @author nadeem Date : 30/07/24
 */
public class Palindrome {

    public boolean isPalindrome(String input) {
        if (input == null || input.isEmpty()) return false;
        int start = 0;
        int end = input.length();

        boolean hasAlpha = false;
        while (start < end) {
            char firstChar = input.charAt(start);
            char secondChar = input.charAt(start);

            if (!Character.isLetter(firstChar)) {
                start++;
                continue;
            }
            if (!Character.isLetter(secondChar)) {
                end--;
                continue;
            }
            hasAlpha = true;
            if (Character.toLowerCase(firstChar) != Character.toLowerCase(secondChar)) {
                return false;
            }

            start++;
            end--;
        }
        return hasAlpha;
    }

    public int getPalindromeLength(String input) {
        if (input == null || input.isEmpty()) return 0;
        int start = 0;
        int end = input.length() - 1;

        int len = 0;
        while (start <= end) {
            if (start == end) return len + 1;
            char firstChar = input.charAt(start);
            char secondChar = input.charAt(end);

            if (!Character.isLetter(firstChar)) {
                start++;
                continue;
            }
            if (!Character.isLetter(secondChar)) {
                end--;
                continue;
            }
            if (Character.toLowerCase(firstChar) != Character.toLowerCase(secondChar)) {
                return 0;
            }

            len += 2;

            start++;
            end--;
        }
        return len;
    }

    public String[] getLongestPalindromes(String input) {
        if (input == null || input.isEmpty()) return new String[] {};
        int n = input.length();

        int maxLen = 0;
        Set<String> ans = new HashSet<>();
        for (int i = 1; i < n - 1; i++) {
            int left = i - 1;
            int right = i + 1;
            while (left >= 0 && right < n) {
                String currentSubString = input.substring(left, right + 1);
                int len = getPalindromeLength(currentSubString);
                if (len > maxLen) {
                    maxLen = len;
                    ans = new HashSet<>();
                    ans.add(currentSubString);
                }
                if (len == maxLen) {
                    ans.add(currentSubString);
                }

                left--;
                right++;
            }
            left = i;
            right = i + 1;
            while (left >= 0 && right < n) {
                String currentSubString = input.substring(left, right + 1);
                int len = getPalindromeLength(currentSubString);
                if (len > maxLen) {
                    maxLen = len;
                    ans = new HashSet<>();
                    ans.add(currentSubString);
                }
                if (len == maxLen) {
                    ans.add(currentSubString);
                }

                left--;
                right++;
            }
        }
        return ans.toArray(new String[0]);
    }

    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        String[] palindromes = palindrome.getLongestPalindromes("Racecars racing");
        System.out.println(Arrays.toString(palindromes));
    }
}
