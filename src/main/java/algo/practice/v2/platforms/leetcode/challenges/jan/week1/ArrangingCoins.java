package algo.practice.v2.platforms.leetcode.challenges.jan.week1;

/**
 * https://leetcode.com/problems/arranging-coins/
 *
 * @author Nadeem 2021-01-05
 */
public class ArrangingCoins {

    private int ans;
    private int sum;

    public static void main(String[] args) {
        int n = 8;
        ArrangingCoins arrangingCoins = new ArrangingCoins();
        int noOfStairs = arrangingCoins.arrangeCoins(n);
        System.out.println("noOfStairs = " + noOfStairs);
    }

    public int arrangeCoins(int n) {
        //        arrangeCoins(1, n);
        //        return ans;
        return arrangeCoinsIterative(n);
    }

    private int arrangeCoinsIterative(int n) {
        long sum = 0;
        int ans = 0;
        int curr = 1;
        while (sum <= n) {
            sum += curr++;
            if (sum <= n) {
                ans++;
            }
        }
        return ans;
    }

    private void arrangeCoins(int i, int n) {
        sum += i;
        if (sum > n) {
            return;
        }
        ans++;
        arrangeCoins(i + 1, n);
    }
}
