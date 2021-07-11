package algo.practice.v2.oj.leetcode.challenges.dec.week4;

import algo.practice.v2.utils.TreeNode;

/**
 * This is the description of what this type does
 *
 * @author Nadeem 2020-12-23
 */
public class BalancedBinaryTree {

    private boolean isBalanced = true;

    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return isBalanced;
        //        if (root == null) {
        //            return true;
        //        }
        //        int lh = height(root.left);
        //        int rh = height(root.right);
        //        if (Math.abs(lh - rh) > 1) {
        //            return false;
        //        }
        //        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int dfs(TreeNode root) {
        if (!isBalanced) {
            return 0;
        }
        if (root == null) {
            return 0;
        }
        int lh = dfs(root.left);
        int rh = dfs(root.right);
        if (Math.abs(lh - rh) > 1) {
            isBalanced = false;
        }
        return 1 + Math.max(lh, rh);
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }
}
