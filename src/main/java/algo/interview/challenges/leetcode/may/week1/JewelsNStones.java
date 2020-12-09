package algo.interview.challenges.leetcode.may.week1;

import java.util.Arrays;

public class JewelsNStones {

    public int numJewelsInStones(String J, String S) {
        int[] count = new int[128];
        Arrays.fill(count, -1);
        for (char c : J.toCharArray()) {
            count[c - 'A'] = 0;
        }
        for (char c : S.toCharArray()) {
            if (count[c - 'A'] < 0) {
                continue;
            }
            count[c - 'A']++;
        }
        int sum = 0;
        for (int i : count) {
            if (i > 0) {
                sum += i;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String J = "aA";
        String S = "aAAbbbb";
        JewelsNStones jewelsNStones = new JewelsNStones();
        int jewels = jewelsNStones.numJewelsInStones(J, S);
        System.out.println("jewels = " + jewels);
    }
}
