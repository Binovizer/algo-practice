package algo.tree;

import algo.utils.AssortedMethods;

/**
 * The type CheckSubtree
 *
 * @author Mohd Nadeem
 */
public class CheckSubtree {

    public static void main(String[] args) {
        TreeNode tree1 = AssortedMethods.createTreeFromArray(new int[] {1, 2, 3, 4, 5, 6});
        tree1.print();
        TreeNode tree2 = AssortedMethods.createTreeFromArray(new int[] {2, 4, 5});
        tree2.print();

        CheckSubtree checkSubtree = new CheckSubtree();
        boolean subtree = checkSubtree.isSubtree(tree2, tree1);
        System.out.println("subtree = " + subtree);
    }

    public boolean isSubtree(TreeNode subtree, TreeNode tree) {
        if (subtree == null && tree == null) {
            return true;
        }
        if (subtree == null || tree == null) {
            return false;
        }
        if (subtree.data == tree.data) {
            return isIdentical(subtree, tree);
        }
        return isSubtree(subtree, tree.left) || isSubtree(subtree, tree.right);
    }

    private boolean isIdentical(TreeNode subtree, TreeNode tree) {
        if (subtree == null && tree == null) {
            return true;
        }
        if (subtree == null || tree == null) {
            return false;
        }
        if (subtree.data != tree.data) {
            return false;
        }
        return isIdentical(subtree.left, tree.left) && isIdentical(subtree.right, tree.right);
    }
}
