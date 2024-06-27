package algo.practice.v2.oj.leetcode.contests.BW_131;

import java.util.HashMap;
import java.util.Map;

/**
 * The type C
 *
 * @author nadeem Date : 25/05/24
 */
public class C {

    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer, Integer> colorToCountMap = new HashMap<>();
        Map<Integer, Integer> ballToColorMap = new HashMap<>();
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int ball = queries[i][0];
            int newColor = queries[i][1];
            if (ballToColorMap.containsKey(ball)) {
                int existingColor = ballToColorMap.get(ball);
                if (colorToCountMap.get(existingColor) == 1) {
                    colorToCountMap.remove(existingColor);
                } else {
                    colorToCountMap.put(existingColor, colorToCountMap.get(existingColor) - 1);
                }
            }
            ballToColorMap.put(ball, newColor);
            colorToCountMap.put(newColor, colorToCountMap.getOrDefault(newColor, 0) + 1);

            ans[i] = colorToCountMap.size();
        }
        return ans;
    }
}
