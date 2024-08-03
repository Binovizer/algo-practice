package algo.practice.v2.oj.leetcode.contests.BW_131;

import java.util.*;

/**
 * The type D
 *
 * @author nadeem Date : 25/05/24
 */
public class D {

    public List<Boolean> getResults(int[][] queries) {
        TreeSet<Integer> obs = new TreeSet<>();

        int len = 50000;
        int[] ans = new int[len+1];
        for(int i = 0; i < ans.length; i++) {
            ans[i] = i+1;
        }
        List<Boolean> out = new ArrayList<>();
        for (int[] query : queries) {
            int type = query[0];
            int x = query[1];
            if (type == 1) {
                Integer ceiling = obs.ceiling(x);
                ceiling = ceiling == null ? len : ceiling;
                for (int j = x + 1; j <= ceiling; j++) {
                    ans[j] = j - x;
                }
                obs.add(x);
            } else {
                int sz = query[2];

                out.add(ans[x - 1] >= sz);
            }
        }
        return out;
    }
}
