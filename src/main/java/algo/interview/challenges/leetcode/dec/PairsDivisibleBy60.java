package algo.interview.challenges.leetcode.dec;

/**
 * This is the description of what this type does
 *
 * @author Nadeem 2020-12-09
 */
public class PairsDivisibleBy60 {

    public static void main(String[] args) {
        int[] arr = {30, 20, 150, 100, 40};
        PairsDivisibleBy60 pairsDivisibleBy60 = new PairsDivisibleBy60();
        int numPairsDivisibleBy60 = pairsDivisibleBy60.numPairsDivisibleBy60(arr);
        System.out.println("numPairsDivisibleBy60 = " + numPairsDivisibleBy60);
    }

    public int numPairsDivisibleBy60(int[] times) {
        int[] arr = new int[60];
        int noOfWays = 0;
        for (int time : times) {
            time = time % 60;
            if (time == 0) {
                noOfWays += arr[time];
            } else {
                noOfWays += arr[60 - time];
            }
            arr[time]++;
        }
        return noOfWays;
    }
}
