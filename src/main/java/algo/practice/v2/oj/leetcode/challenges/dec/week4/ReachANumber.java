package algo.practice.v2.oj.leetcode.challenges.dec.week4;

/**
 * This is the description of what this type does
 *
 * @author Nadeem 2020-12-28
 */
public class ReachANumber {

    public static void main(String[] args) {
        int target = 2;
        ReachANumber reachANumber = new ReachANumber();
        int minMoves = reachANumber.reachNumber(target);
        System.out.println("minMoves = " + minMoves);
    }

    public int reachNumber(int target) {
        target = Math.abs(target);
        int k = 0;
        while (target > 0) {
            target -= ++k;
        }
        return target % 2 == 0 ? k : k + 1 + k % 2;
    }
}
