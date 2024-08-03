package algo.practice.v2.oj.leetcode.challenges.dec.week3;

/**
 * This is the description of what this type does
 *
 * @author Nadeem 2020-12-20
 */
public class IncreasingTriplet {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        IncreasingTriplet increasingTriplet = new IncreasingTriplet();
        boolean exists = increasingTriplet.increasingTripletOptimized(nums);
        System.out.println("exists = " + exists);
    }

    public boolean increasingTriplet(int[] nums) {
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] < nums[j] && nums[j] < nums[k]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean increasingTripletOptimized(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= first) {
                first = num;
            } else if (num <= second) {
                second = num;
            } else {
                return true;
            }
        }
        return false;
    }
}
