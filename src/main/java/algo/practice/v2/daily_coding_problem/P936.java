package algo.practice.v2.daily_coding_problem;

import algo.practice.v2.utils.TreeNode;

/**
 * The type P936
 *
 * @author nadeem Date : 13/02/24
 */
public class P936 {

    public int sumInRange(TreeNode root, int from, int to) {
        if (root == null) return 0;
        int sum = 0;
        sum += sumInRange(root.left, from, to);
        if (from <= root.val && root.val <= to) {
            sum += root.val;
        }
        sum += sumInRange(root.right, from, to);
        return sum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(10);

        P936 p936 = new P936();
        int sum = p936.sumInRange(root, 4, 9);
        System.out.println("sum = " + sum);
    }
}
