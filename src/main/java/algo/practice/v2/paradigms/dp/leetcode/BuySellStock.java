package algo.practice.v2.paradigms.dp.leetcode;

/**
 * This is the description of what this type does
 *
 * @author Nadeem 2020-12-08
 */
public class BuySellStock {

    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};
        BuySellStock buySellStock = new BuySellStock();
        int maxProfit = buySellStock.maxProfitOptimized(arr);
        System.out.println("maxProfit = " + maxProfit);
    }

    private int maxProfit(int[] arr) {
        if (arr.length <= 1) {
            return 0;
        }
        int n = arr.length;
        int[] prefix = new int[n];
        prefix[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = Math.min(arr[i], prefix[i - 1]);
        }
        int[] suffix = new int[n];
        suffix[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = Math.max(arr[i], suffix[i + 1]);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (suffix[i] - prefix[i] > max) {
                max = suffix[i] - prefix[i];
            }
        }
        return max;
    }

    private int maxProfitOptimized(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int maxProfit = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int price : prices) {
            min = Math.min(min, price);
            maxProfit = Math.max(maxProfit, price - min);
        }
        return maxProfit;
    }
}
