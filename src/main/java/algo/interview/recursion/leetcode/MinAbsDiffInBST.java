package algo.interview.recursion.leetcode;

import algo.interview.utils.TreeNode;

/**
 * This class helps find the minimum absolute difference in a BST
 * Problem Description : https://leetcode.com/problems/minimum-absolute-difference-in-bst/
 *
 * @author Nadeem 2020-11-25
 */
public class MinAbsDiffInBST {

    private static int min;
    private static TreeNode prev;

    public int getMinimumDifference(TreeNode root) {
        min = Integer.MAX_VALUE;
        prev = null;
        getMinimumDifferenceUtil(root);
        return min;
    }

    public void getMinimumDifferenceUtil(TreeNode root) {
        if(root == null){
            return;
        }
        getMinimumDifferenceUtil(root.left);
        if(prev != null){
            min = Math.min(min, root.val - prev.val);
        }
        prev = root;
        getMinimumDifferenceUtil(root.right);
    }
}
