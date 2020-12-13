package algo.practice.v2.platforms.interviewbit.math;

import java.util.Arrays;

/**
 * This is the description of what this type does
 *
 * @author Nadeem 2020-12-13
 */
public class SortedPermutationRank {

    private static final int M = 1000003;

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

        long denom = 1;
        for (int value : charMap) {
            if (factMemo[value] == -1) {
                factMemo[value] = fact(value);
            }
            denom = (denom % M * modExp(factMemo[value], M - 2)) % M;
        }
        long ans = 0;
        int i = 0;
        while (i < n - 1) {
            char currentChar = str.charAt(i);
            int smallerCharsCount = 0;
            // find no of chars that are smaller than this char
            for (int j = currentChar - 'A' - 1; j >= 0; j--) {
                if (charMap[j] > 0) {
                    smallerCharsCount += charMap[j];
                }
            }
            ans =
                    (ans % M + (smallerCharsCount % M * (fact(n - i - 1) % M * denom % M) % M) % M)
                            % M;
            denom = (denom % M * charMap[currentChar - 'A'] % M) % M;
            charMap[currentChar - 'A']--;
            i++;
        }
        return new Long(ans + 1).intValue();
    }

    public long modExp(long xint, long yint) {
        long res = 1;
        long x = xint;
        long y = yint;
        // System.out.println("Exp " + x + " " + y + " " + res);
        while (y > 0) {
            if ((y & 1) == 1) {
                res = (res * x) % M;
            }
            x = (x * x) % M;
            y >>= 1;
            // System.out.println("Exp " + x + " " + y + " " + res);
        }
        // return new Long(res).intValue();
        return res;
    }

    private int fact(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (factMemo[n] != -1) {
            return factMemo[n];
        }
        return factMemo[n] = (n % M * fact(n - 1) % M) % M;
    }
}
