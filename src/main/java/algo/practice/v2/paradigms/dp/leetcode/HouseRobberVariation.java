package algo.practice.v2.paradigms.dp.leetcode;

import java.util.Map;
import java.util.TreeMap;

/**
 * The type HouseRobberVariation
 *
 * @author nadeem Date : 02/06/24
 */
public class HouseRobberVariation {
    public static void main(String[] args) {
        int[] nums = {2, 2, 4, 2, 6, 2, 8};
        HouseRobberVariation houseRobber = new HouseRobberVariation();
        int maxRobbery = houseRobber.maximizeSweetness(nums);
        System.out.println("maxRobbery = " + maxRobbery);
    }

    public int maximizeSweetness(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        // Count frequencies of each sweetness score
        TreeMap<Integer, Integer> frequencyMap = new TreeMap<>();
        for (int sweetness : arr) {
            frequencyMap.put(sweetness, frequencyMap.getOrDefault(sweetness, 0) + 1);
        }

        // Extract unique sweetness scores
        int n = frequencyMap.size();
        int[] uniqueScores = new int[n];
        int[] frequency = new int[n];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            uniqueScores[index] = entry.getKey();
            frequency[index] = entry.getValue();
            index++;
        }

        // Initialize dp array
        int[] dp = new int[n];
        dp[0] = uniqueScores[0] * frequency[0];

        if (n > 1) {
            if (uniqueScores[1] - 1 == uniqueScores[0])
                dp[1] = Math.max(dp[0], uniqueScores[1] * frequency[1]);
            else {
                dp[1] = dp[0] + uniqueScores[1] * frequency[1];
            }
        }

        // Fill the dp array
        for (int i = 2; i < n; i++) {
            // If the last element in x-1, we can't
            if (uniqueScores[i - 1] + 1 == uniqueScores[i]) {
                dp[i] = Math.max(uniqueScores[i] * frequency[i] + dp[i - 2], dp[i - 1]);
            } else {
                dp[i] = uniqueScores[i] * frequency[i] + dp[i - 1];
            }
        }

        // The last element of dp contains the maximum sweetness score
        return dp[n - 1];
    }
}
