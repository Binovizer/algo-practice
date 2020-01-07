package algo.tree;

import algo.utils.AssortedMethods;

/**
 * The type HeightOfBT
 *
 * @author Mohd Nadeem
 */
public class HeightOfBT {

    public static void main(String[] args) {
        TreeNode node = AssortedMethods.createTreeFromArray(new int[] {1, 2, 3, 4, 5, 6, 7, 8});
        node.print();

        HeightOfBT heightOfBT = new HeightOfBT();
        int height = heightOfBT.getHeight(node);
        System.out.println("height = " + height);
    }

    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}
