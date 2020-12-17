package algo.practice.v2.platforms.leetcode.challenges.dec.week3;

import algo.practice.v2.utils.TreeNode;

/**
 * This is the description of what this type does
 *
 * @author Nadeem 2020-12-17
 */
public class ValidateBST {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }
}
