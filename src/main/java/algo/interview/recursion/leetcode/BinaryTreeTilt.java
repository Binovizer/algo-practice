package algo.interview.recursion.leetcode;

import algo.interview.utils.TreeNode;

/**
 * This class helps find the tilt of binary tree Problem Desc :
 * https://leetcode.com/problems/binary-tree-tilt/
 *
 * @author Nadeem 2020-11-28
 */
public class BinaryTreeTilt {

    private static int sumOfTilts;

    public int findTilt(TreeNode root) {
        sumOfTilts = 0;
        sum(root);
        return sumOfTilts;
    }

    private int sum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSum = sum(root.left);
        int rightSum = sum(root.right);
        sumOfTilts += Math.abs(leftSum - rightSum);
        return leftSum + rightSum + root.val;
    }
}
