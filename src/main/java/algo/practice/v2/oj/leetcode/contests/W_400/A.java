package algo.practice.v2.oj.leetcode.contests.W_400;

/**
 * The type A
 *
 * @author nadeem Date : 11/06/24
 */
public class A {

    public static void main(String[] args) {}

    public int minimumChairs(String s) {
        int minRequired = 0;
        int chairsUsed = 0;
        for (char c : s.toCharArray()) {
            if (c == 'E') {
                chairsUsed++;
            } else {
                chairsUsed--;
            }
            minRequired = Math.max(minRequired, chairsUsed);
        }
        return minRequired;
    }
}
