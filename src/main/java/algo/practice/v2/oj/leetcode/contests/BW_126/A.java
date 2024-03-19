package algo.practice.v2.oj.leetcode.contests.BW_126;


/**
 * The type A
 *
 * @author nadeem Date : 19/03/24
 */
public class A {
    public int sumOfEncryptedInt(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += encrypt(num);
        }
        return sum;
    }

    private int encrypt(int num) {
        int temp = num;
        int count = 0;
        int maxD = -1;
        while (num > 0) {
            int d = num % 10;
            maxD = Math.max(maxD, d);
            num /= 10;
        }
        int ans = 0;
        while (temp > 0) {
            temp /= 10;
            ans = ans * 10 + maxD;
        }
        return ans;
    }
}
