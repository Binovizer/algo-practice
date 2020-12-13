package algo.practice.v2.platforms.interviewbit.math;

import java.util.Arrays;

/**
 * This is the description of what this type does
 *
 * @author Nadeem 2020-12-13
 */
public class SortedPermutationRank {

    private int[] factMemo;

    public static void main(String[] args) {
        String str = "BBBBAAAA";
        SortedPermutationRank sortedPermutationRank = new SortedPermutationRank();
        int rank = sortedPermutationRank.findRankWithRepeat(str);
        System.out.println("rank = " + rank);
    }

    private int findRank(String str) {
        int n = str.length();
        factMemo = new int[n + 1];
        Arrays.fill(factMemo, -1);
        boolean[] charMap = new boolean[256];
        for (char c : str.toCharArray()) {
            charMap[c - 'A'] = true;
        }
        int ans = 0;
        int i = 0;
        int curLen = n;
        while (i < n - 1) {
            char currentChar = str.charAt(i);
            int smallerCharsCount = 0;
            // find no of chars that are smaller than this char
            for (int j = currentChar - 'A' - 1; j >= 0; j--) {
                if (charMap[j]) {
                    smallerCharsCount++;
                }
            }
            ans += (smallerCharsCount * fact(curLen - 1));
            charMap[currentChar - 'A'] = false;
            i++;
            curLen--;
        }
        return ans + 1;
    }

    private int findRankWithRepeat(String str) {
        int n = str.length();
        factMemo = new int[n + 1];
        Arrays.fill(factMemo, -1);
        int[] charMap = new int[26];
        for (char c : str.toCharArray()) {
            charMap[c - 'A']++;
        }
        int ans = 0;
        int i = 0;
        int curLen = n;
        while (i < n - 1) {
            char currentChar = str.charAt(i);
            int smallerCharsCount = 0;
            // find no of chars that are smaller than this char
            int divisor = 1;
            for (int j = currentChar - 'A' - 1; j >= 0; j--) {
                if (charMap[j] > 0) {
                    if (factMemo[charMap[j]] == -1) {
                        factMemo[charMap[j]] = fact(charMap[j]);
                    }
                    divisor *= factMemo[charMap[j]];
                    smallerCharsCount++;
                }
            }
            ans += (smallerCharsCount * (fact(curLen - 1) / divisor));
            charMap[currentChar - 'A']--;
            i++;
            curLen--;
        }
        return ans + 1;
    }

    private int fact(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (factMemo[n] != -1) {
            return factMemo[n];
        }
        return factMemo[n] = n * fact(n - 1);
    }
}
