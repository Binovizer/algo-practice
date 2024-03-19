package algo.practice.v2.oj.leetcode.contests.BW_126;

import java.util.PriorityQueue;

/**
 * The type B
 *
 * @author nadeem Date : 19/03/24
 */
public class B {

    public long[] unmarkedSumArray(int[] nums, int[][] queries) {
        int n = nums.length;
        boolean[] vis = new boolean[n];

        int visited = 0;

        PriorityQueue<int[]> minHeap =
                new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);

        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            minHeap.add(new int[] {i, nums[i]});
        }

        // System.out.println(sum);

        long[] ans = new long[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int index = queries[i][0];
            int k = queries[i][1];

            if (!vis[index]) {
                sum -= nums[index];
                vis[index] = true;
                visited += 1;
            }
            while (k > 0 && visited != n && !minHeap.isEmpty()) {
                int[] poll = minHeap.poll();
                if (vis[poll[0]]) continue;
                sum -= poll[1];
                vis[poll[0]] = true;
                visited += 1;
                k--;
            }
            ans[i] = sum;
        }
        return ans;
    }
}
