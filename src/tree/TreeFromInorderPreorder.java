package tree;

/**
 * The type TreeFromInorderPreorder
 *
 * @author Mohd Nadeem
 */
public class TreeFromInorderPreorder {

    public static void main(String[] args) {
        int[] inorder = {4, 2, 5, 1, 6, 3};
        int[] preorder = {1, 2, 4, 5, 3, 6};
        TreeFromInorderPreorder treeFromInorderPreorder = new TreeFromInorderPreorder();
        TreeNode treeNode = treeFromInorderPreorder.buildTree(inorder, preorder, 6);
        treeNode.print();
    }

    public TreeNode buildTree(int[] inorder, int[] preorder, int size) {
        return buildTree(inorder, preorder, 0, size - 1, 0, size - 1);
    }

    public TreeNode buildTree(int[] inorder, int[] preorder, int inS, int inE, int preS, int preE) {
        if (inS > inE) {
            return null;
        }
        int rootData = preorder[preS];
        int rootIndex = -1;
        for (int i = inS; i <= inE; i++) {
            if (inorder[i] == rootData) {
                rootIndex = i;
                break;
            }
        }
        int lInS = inS;
        int lInE = rootIndex - 1;
        int lPreS = preS + 1;
        int lPreE = lInE - lInS + lPreS;
        int rInS = rootIndex + 1;
        int rInE = inE;
        int rPreS = lPreE + 1;
        int rPreE = preE;
        TreeNode root = new TreeNode(preorder[preS]);
        root.left = buildTree(inorder, preorder, lInS, lInE, lPreS, lPreE);
        root.right = buildTree(inorder, preorder, rInS, rInE, rPreS, rPreE);
        return root;
    }
}
