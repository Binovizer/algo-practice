package algo.practice.v2.platforms.leetcode.challenges.jan.week1;

/**
 * https://leetcode.com/problems/beautiful-arrangement/
 *
 * @author Nadeem 2021-01-03
 */
public class BeautifulArrangement {

    private int ans;
    private boolean[] included;

    public static void main(String[] args) {
        int n = 4;
        BeautifulArrangement beautifulArrangement = new BeautifulArrangement();
        int arrangements = beautifulArrangement.countArrangement(n);
        System.out.println("arrangements = " + arrangements);
    }

    public int countArrangement(int n) {
        included = new boolean[n + 1];
        dfs(1, n);
        return ans;
    }

    private void dfs(int index, int n) {
        if (index > n) {
            ans++;
        }
        for (int i = 1; i <= n; i++) {
            if (!included[i] && (i % index == 0 || index % i == 0)) {
                included[i] = true;
                dfs(index + 1, n);
                included[i] = false;
            }
        }
    }
}
