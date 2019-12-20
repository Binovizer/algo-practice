package tree;

/**
 * The type HeightOfBT
 *
 * @author Mohd Nadeem
 */
public class HeightOfBT {

  public int getHeight(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
  }
}
