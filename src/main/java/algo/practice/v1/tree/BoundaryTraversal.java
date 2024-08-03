package algo.practice.v1.tree;

import algo.practice.v1.utils.AssortedMethods;

/**
 * The type BoundaryTraversal
 *
 * @author Mohd Nadeem
 */
public class BoundaryTraversal {

    private static final String SPACE = " ";

    public static void main(String[] args) {
        TreeNode treeNode =
                AssortedMethods.createTreeFromArray(new int[] {5, 6, 3, 8, 1, 2, 3, 4, 9});
        treeNode.print();

        BoundaryTraversal boundaryTraversal = new BoundaryTraversal();
        boundaryTraversal.boundaryTraversal(treeNode);
    }

    public void boundaryTraversal(TreeNode node) {
        System.out.print("Boundary Traversal : ");
        if (node == null) {
            return;
        }
        System.out.print(node.data + SPACE);

        // Print the left boundary in top-down manner.
        printBoundaryLeft(node.left);

        printLeaves(node.left);
        printLeaves(node.right);

        // Print the right boundary in bottom-up manner.
        printBoundaryRight(node.right);
    }

    private void printBoundaryLeft(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            System.out.print(node.data + SPACE);
            printBoundaryLeft(node.left);
        } else if (node.right != null) {
            System.out.print(node.data + SPACE);
            printBoundaryLeft(node.right);
        }
    }

    private void printBoundaryRight(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.right != null) {
            printBoundaryRight(node.right);
            System.out.print(node.data + SPACE);
        } else if (node.left != null) {
            printBoundaryRight(node.left);
            System.out.print(node.data + SPACE);
        }
    }

    private void printLeaves(TreeNode root) {
        if (root == null) {
            return;
        }
        printLeaves(root.left);
        if (root.left == null && root.right == null) {
            System.out.print(root.data + SPACE);
        }
        printLeaves(root.right);
    }
}
