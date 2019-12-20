package tree;

import utils.AssortedMethods;

/**
 * The type MaxNodeBetweenTwoLeaves
 *
 * @author Mohd Nadeem
 */
public class MaxSumBetweenTwoLeaves {

  private static int MAX_DIS = Integer.MIN_VALUE;

  public static void main(String[] args) {
    TreeNode treeFromArray = AssortedMethods.createTreeFromArray(new int[] {1, 1, 2, -3, 2});
    treeFromArray.print();
    MaxSumBetweenTwoLeaves maxSumBetweenTwoLeaves = new MaxSumBetweenTwoLeaves();
    int maxSum = maxSumBetweenTwoLeaves.maxSum(treeFromArray);
    System.out.println("maxSum = " + maxSum);
  }

  public int maxSum(TreeNode root) {
    maxSumUtil(root);
    return MAX_DIS;
  }

  private int maxSumUtil(TreeNode root) {
    if (root == null) {
      return 0;
    }
    if (root.left == null && root.right == null) {
      return root.data;
    }
    int ls = maxSumUtil(root.left);
    int rs = maxSumUtil(root.right);
    MAX_DIS = Math.max(ls + rs + root.data, MAX_DIS);
    return Math.max(ls, rs) + root.data;
  }
}
