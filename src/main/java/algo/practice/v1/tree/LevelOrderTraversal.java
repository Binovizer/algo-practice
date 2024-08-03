package algo.practice.v1.tree;

import algo.practice.v1.utils.AssortedMethods;

import java.util.LinkedList;
import java.util.Queue;

/**
 * The type LevelOrderTraversal
 *
 * @author Mohd Nadeem
 */
public class LevelOrderTraversal {

    private static int maxLevel = -1;

    public static void main(String[] args) {
        TreeNode root = AssortedMethods.createTreeFromArray(new int[] {1, 2, 3, 4, 5, 6, 7});
        root.print();

        LevelOrderTraversal levelOrderTraversal = new LevelOrderTraversal();
        //        levelOrderTraversal.traverseRecursive(root);
        levelOrderTraversal.traverseRecursiveLevelWise(root, 0);
    }

    public void traverse(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if (root != null) {
            q.add(root);
        }
        while (!q.isEmpty()) {
            TreeNode poll = q.poll();
            System.out.print(poll.data + " ");
            if (poll.left != null) {
                q.add(poll.left);
            }
            if (poll.right != null) {
                q.add(poll.right);
            }
        }
    }

    public void traverseRecursive(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            System.out.print(root.left.data + " ");
        }
        if (root.right != null) {
            System.out.print(root.right.data + " ");
        }
        traverseRecursive(root.left);
        traverseRecursive(root.right);
    }

    public void traverseRecursiveLevelWise(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (level == 0) {
            System.out.print(root.data + " ");
        }
        if (maxLevel < level) {
            maxLevel = level;
            System.out.println();
        }
        if (root.left != null) {
            System.out.print(root.left.data + " ");
        }
        if (root.right != null) {
            System.out.print(root.right.data + " ");
        }
        traverseRecursiveLevelWise(root.left, level + 1);
        traverseRecursiveLevelWise(root.right, level + 1);
    }
}
