package algo.leetcode.challenge.may.week1;

import algo.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * CousinsInBinaryTree helps in checking if <b>x</b> and <b>y</b> are cousins in the given tree.
 * <a href="https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3322/">Cousins in a Binary Tree</a>
 *
 * @author Nadeem 2020-06-08 4:48 PM
 */
public class CousinsInBinaryTree {

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean isXExist = false;
        boolean isYExist = false;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = q.poll();
                if (current.data == x) isXExist = true;
                if (current.data == y) isYExist = true;
                if (current.left != null && current.right != null) {
                    if (current.left.data == x && current.right.data == y) return false;
                    else if (current.left.data == y && current.right.data == x) return false;
                }
                if (current.left != null) {
                    q.offer(current.left);
                }
                if (current.right != null) {
                    q.offer(current.right);
                }
            }
            if (isXExist && isYExist) return true;
            else if (isXExist || isYExist) return false;
        }
        return false;
    }

}
