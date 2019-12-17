package tree;

import utils.AssortedMethods;

/**
 * The type RootToLeafPathSum
 *
 * @author Mohd Nadeem
 */
public class RootToLeafPathSum {

    private static int sum = 0;

    public static void main(String[] args) {
        TreeNode root = AssortedMethods.createTreeFromArray(new int[]{0,1,3,4,5,6});
        root.print();


        RootToLeafPathSum rootToLeafPathSum = new RootToLeafPathSum();
        rootToLeafPathSum.sum(root);
        System.out.println("sum = " + sum);
    }

    private void sum(TreeNode root) {
//        sum(root, "");
        sum(root, 0);
    }

    private void sum(TreeNode root, String path) {
        if(root == null){
            return;
        }
        path += String.valueOf(root.data);
        if(root.left == null && root.right == null){
            sum += Integer.parseInt(path);
        }
        sum(root.left, path);
        sum(root.right, path);
    }

    private void sum(TreeNode root, int val) {
        if(root == null){
            return;
        }
        val = val * 10 + root.data;
        if(root.left == null && root.right == null){
            sum += val;
        }
        sum(root.left, val);
        sum(root.right, val);
    }
}
