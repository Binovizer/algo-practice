package algo.tree;

import algo.utils.AssortedMethods;

/**
 * The type FindParent
 *
 * @author Mohd Nadeem
 */
public class FindParent {

    private static int parent;

    public static void main(String[] args) {
        TreeNode treeFromArray = AssortedMethods.createTreeFromArray(new int[] {1, 2, 3, 4, 5, 6});
        treeFromArray.print();
        FindParent findParent = new FindParent();
        int parent = findParent.find(treeFromArray, 5);
        System.out.println("parent = " + parent);
    }

    private int find(TreeNode treeFromArray, int val) {
        return findParentUtil2(treeFromArray, val, -1);
    }

    private void findParentUtil(TreeNode root, int val, int currParent) {
        if (root == null) {
            return;
        }
        if (root.data == val) {
            parent = currParent;
            return;
        }
        findParentUtil(root.left, val, root.data);
        findParentUtil(root.right, val, root.data);
    }

    private int findParentUtil2(TreeNode root, int val, int currParent) {
        if (root == null) {
            return -1;
        }
        if (root.data == val) {
            return currParent;
        }
        int leftIndex = findParentUtil2(root.left, val, root.data);
        return (leftIndex == -1) ? findParentUtil2(root.right, val, root.data) : leftIndex;
    }
}
