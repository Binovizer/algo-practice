package algo.tree;

import algo.utils.AssortedMethods;

import java.util.LinkedList;
import java.util.Queue;

/**
 * The type LeftView
 *
 * @author Mohd Nadeem
 */
public class LeftView {

    private static int maxLevel = -1;

    public static void main(String[] args) {
        TreeNode root = AssortedMethods.createTreeFromArray(new int[] {1, 2, 3, 4, 5, 6, 7});
        root.print();

        LeftView leftView = new LeftView();
        leftView.printLeftViewRecursive(root);
    }

    private void printLeftView(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = q.poll();
                if (i == 0) {
                    System.out.println(poll.data);
                }
                if (poll.left != null) {
                    q.offer(poll.left);
                }
                if (poll.right != null) {
                    q.offer(poll.right);
                }
            }
        }
    }

    private void printLeftViewRecursive(TreeNode root) {
        printLeftViewRecursive(root, 0);
    }

    private void printLeftViewRecursive(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (level > maxLevel) {
            maxLevel = level;
            System.out.println(root.data);
        }
        printLeftViewRecursive(root.left, level + 1);
        printLeftViewRecursive(root.right, level + 1);
    }
}
