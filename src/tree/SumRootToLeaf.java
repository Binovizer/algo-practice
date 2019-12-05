package tree;

import utils.AssortedMethods;

/**
 * The type SumRootToLeaf
 *
 * @author Mohd Nadeem
 */
public class SumRootToLeaf {

    private static int sum = 0;

    public int sumRootToLeaf(TreeNode root) {
        sumRootToLeafUtil(root, "");
        return sum;
    }

    private void sumRootToLeafUtil(TreeNode root, String path) {
        if(root == null){
            return;
        }
        path += root.data;
        if(root.left == null && root.right == null){
            System.out.println(path);
            sum += getNumberFromBin(path);
        } else {
            sumRootToLeafUtil(root.left, path);
            sumRootToLeafUtil(root.right, path);
        }
    }

    private int getNumberFromBin(String bin){
        return Integer.parseInt(bin, 2);
    }

    public static void main(String[] args) {
        TreeNode treeFromArray = AssortedMethods.createTreeFromArray(new int[]{1,0,1,0,1,0,1});
        treeFromArray.print();

        SumRootToLeaf sumRootToLeaf = new SumRootToLeaf();
        System.out.println("sumRootToLeaf = " + sumRootToLeaf.sumRootToLeaf(treeFromArray));
    }
}
