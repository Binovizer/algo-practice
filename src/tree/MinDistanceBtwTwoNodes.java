package tree;

import utils.AssortedMethods;

/**
 * The type MinDistanceBtwTwoNodes
 *
 * @author Mohd Nadeem
 */
public class MinDistanceBtwTwoNodes {

    public static void main(String[] args) {
        TreeNode root = AssortedMethods.createTreeFromArray(new int[]{1, 2, 3, 4, 5, 6, 7});
        root.print();

        MinDistanceBtwTwoNodes minDistanceBtwTwoNodes = new MinDistanceBtwTwoNodes();
        int distance = minDistanceBtwTwoNodes.minDistance(root, 3, 4);
        System.out.println("distance = " + distance);
    }

    private TreeNode LCA(TreeNode root, int a, int b){
        if(root == null){
            return null;
        }
        if(root.data == a || root.data == b){
            return root;
        }
        TreeNode left = LCA(root.left, a, b);
        TreeNode right = LCA(root.right, a, b);
        if(left != null && right != null){
            return root;
        }
        return (left != null) ? left : right;
    }


    private int minDistance(TreeNode root, int a, int b) {

        return -1;
    }
}
