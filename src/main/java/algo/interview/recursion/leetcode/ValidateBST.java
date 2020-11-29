package algo.interview.recursion.leetcode;

import algo.interview.utils.TreeNode;

/**
 * Problem Desc :
 *
 * @author Nadeem 2020-11-29
 */
public class ValidateBST {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long low, long high) {
        if (root == null) {
            return true;
        }
        if (root.val <= low || root.val >= high) {
            return false;
        }
        return isValidBST(root.left, low, root.val) && isValidBST(root.right, root.val, high);
    }
}
