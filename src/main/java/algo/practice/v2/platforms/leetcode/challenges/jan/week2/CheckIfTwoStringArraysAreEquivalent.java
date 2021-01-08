package algo.practice.v2.platforms.leetcode.challenges.jan.week2;

/**
 * This is the description of what this type does
 *
 * @author Nadeem 2021-01-09
 */
public class CheckIfTwoStringArraysAreEquivalent {

    public static void main(String[] args) {
        String[] word1 = {"abc", "d", "defg"};
        String[] word2 = {"abcddefg"};
        CheckIfTwoStringArraysAreEquivalent checkIfTwoStringArraysAreEquivalent =
                new CheckIfTwoStringArraysAreEquivalent();
        boolean areEqual = checkIfTwoStringArraysAreEquivalent.arrayStringsAreEqual(word1, word2);
        System.out.println("areEqual = " + areEqual);
    }

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int n1 = word1.length;
        int n2 = word2.length;
        if (n1 == 0 && n2 == 0) {
            return true;
        }
        if (n1 == 0 || n2 == 0) {
            return false;
        }
        int i = 0, ii = 0;
        int j = 0, jj = 0;
        String s1 = word1[i];
        String s2 = word2[j];
        int l1 = s1.length();
        int l2 = s2.length();
        while (i < n1 && j < n2) {
            while (ii < l1 && jj < l2) {
                if (s1.charAt(ii) != s2.charAt(jj)) {
                    return false;
                }
                ii++;
                jj++;
            }
            if (ii == l1) {
                i++;
                if (i < n1) {
                    s1 = word1[i];
                    l1 = s1.length();
                    ii = 0;
                }
            }
            if (jj == l2) {
                j++;
                if (j < n2) {
                    s2 = word2[j];
                    l2 = s2.length();
                    jj = 0;
                }
            }
        }
        return (i == n1 && j == n2 && ii == l1 && jj == l2);
    }
}
