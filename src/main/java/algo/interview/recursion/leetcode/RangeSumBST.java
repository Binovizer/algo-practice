package algo.interview.recursion.leetcode;

import algo.interview.utils.TreeNode;

/**
 * This class helps find range sum Problem Desc : https://leetcode.com/problems/range-sum-of-bst/
 *
 * @author Nadeem 2020-11-25
 */
public class RangeSumBST {

    private static int sum;

    public int rangeSumBST(TreeNode root, int low, int high) {
        sum = 0;
        rangeSumBSTUtil(root, low, high);
        return sum;
    }

    public void rangeSumBSTUtil(TreeNode root, int low, int high) {
        if (root == null) {
            return;
        }
        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }
        rangeSumBSTUtil(root.left, low, high);
        rangeSumBSTUtil(root.right, low, high);
    }
}
