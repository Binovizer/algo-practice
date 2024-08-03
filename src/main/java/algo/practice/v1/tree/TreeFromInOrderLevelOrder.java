package algo.practice.v1.tree;

/**
 * The type TreeFromInOrderLevelOrder
 *
 * @author Mohd Nadeem
 */
public class TreeFromInOrderLevelOrder {

    public static void main(String[] args) {
        int[] inorder = {4, 8, 10, 12, 14, 20, 22};
        int[] levelorder = {20, 8, 22, 4, 12, 10, 14};
        TreeFromInOrderLevelOrder treeFromInOrderLevelOrder = new TreeFromInOrderLevelOrder();
        TreeNode treeNode = treeFromInOrderLevelOrder.buildTree(inorder, levelorder, 6);
        treeNode.print();
    }

    public TreeNode buildTree(int[] inorder, int[] levelorder, int size) {
        TreeNode startNode = null;
        return buildTree(startNode, inorder, levelorder, 0, size);
    }

    private TreeNode buildTree(
            TreeNode startNode, int[] inorder, int[] levelorder, int inS, int inE) {
        if (inS > inE) {
            return null;
        }
        if (inS == inE) {
            return new TreeNode(inorder[inS]);
        }
        boolean found = false;
        int index = 0;
        for (int i = 0; i < levelorder.length - 1; i++) {
            int data = levelorder[i];
            for (int j = inS; j < inE; j++) {
                if (data == inorder[j]) {
                    startNode = new TreeNode(data);
                    found = true;
                    index = j;
                    break;
                }
            }
            if (found) {
                break;
            }
        }
        startNode.left = buildTree(startNode, inorder, levelorder, inS, index - 1);
        startNode.right = buildTree(startNode, inorder, levelorder, index + 1, inE);
        return startNode;
    }
}
