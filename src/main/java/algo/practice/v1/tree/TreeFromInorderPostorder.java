package algo.practice.v1.tree;

/**
 * The type TreeFromInorderPreorder
 *
 * @author Mohd Nadeem
 */
public class TreeFromInorderPostorder {

    public static void main(String[] args) {
        int[] inorder = {4, 2, 5, 1, 6, 3};
        int[] postorder = {4, 5, 2, 6, 3, 1};
        TreeFromInorderPostorder treeFromInorderPostorder = new TreeFromInorderPostorder();
        TreeNode treeNode = treeFromInorderPostorder.buildTree(inorder, postorder, 6);
        treeNode.print();
    }

    public TreeNode buildTree(int[] inorder, int[] postorder, int size) {
        return buildTree(inorder, postorder, 0, size - 1, 0, size - 1);
    }

    public TreeNode buildTree(
            int[] inorder, int[] postorder, int inS, int inE, int postS, int postE) {
        if (inS > inE) {
            return null;
        }
        int rootData = postorder[postE];
        int rootIndex = -1;
        for (int i = inS; i <= inE; i++) {
            if (inorder[i] == rootData) {
                rootIndex = i;
                break;
            }
        }
        int lInE = rootIndex - 1;
        int lPostE = lInE - inS + postS;
        int rInS = rootIndex + 1;
        int rPostS = lPostE + 1;
        int rPostE = postE - 1;
        TreeNode root = new TreeNode(rootData);
        root.left = buildTree(inorder, postorder, inS, lInE, postS, lPostE);
        root.right = buildTree(inorder, postorder, rInS, inE, rPostS, rPostE);
        return root;
    }
}
