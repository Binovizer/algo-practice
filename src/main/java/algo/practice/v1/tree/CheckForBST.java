package algo.practice.v1.tree;

/**
 * The type CheckForBST
 *
 * @author Mohd Nadeem
 */
public class CheckForBST {

    public static void main(String[] args) {
        TreeNode bst = TreeNode.createMinimalBST(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9});
        bst.print();

        CheckForBST checkForBST = new CheckForBST();
        boolean isBST = checkForBST.isBST(bst);
        System.out.println("isBST = " + isBST);
    }

    private boolean isBST(TreeNode root) {
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBSTUtil(TreeNode root, int minValue, int maxValue) {
        if (root == null) {
            return true;
        }
        if (root.data < minValue || root.data > maxValue) {
            return false;
        }
        return isBSTUtil(root.left, minValue, root.data - 1)
                && isBSTUtil(root.right, root.data + 1, maxValue);
    }
}
