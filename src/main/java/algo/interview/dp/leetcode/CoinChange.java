package algo.interview.dp.leetcode;

import java.util.Arrays;

/**
 * This is the description of what this type does
 *
 * @author Nadeem 2020-12-10
 */
public class CoinChange {

    private int[] dp;

    public static void main(String[] args) {
        int[] coins = {186, 419, 83, 408};
        int amount = 6249;
        long start = System.currentTimeMillis();
        CoinChange coinChange = new CoinChange();
        int minCoins = coinChange.minCoinsBottomUp(coins, amount);
        long end = System.currentTimeMillis();
        System.out.println("minCoins = " + minCoins);
        System.out.println("Time Taken : " + (end - start) + "ms");
    }

    private int coinChange(int[] coins, int amount) {
        dp = new int[amount + 1];
        return minCoinsMemo(coins, amount);
    }

    private int minCoins(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (coin <= amount) {
                min = Math.min(min, 1 + minCoins(coins, amount - coin));
            }
        }
        return min;
    }

    private int minCoinsMemo(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        if (dp[amount] != 0) {
            return dp[amount];
        }

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (coin <= amount) {
                int res;
                if (dp[amount - coin] != 0) {
                    res = dp[amount - coin];
                } else {
                    res = minCoinsMemo(coins, amount - coin);
                }
                dp[amount - coin] = res;
                if (res >= 0) {
                    min = Math.min(min, 1 + res);
                }
            }
        }
        return dp[amount] = (min == Integer.MAX_VALUE) ? -1 : min;
    }

    private int minCoinsBottomUp(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
