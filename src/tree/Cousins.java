package tree;

import utils.AssortedMethods;

import java.util.LinkedList;
import java.util.Queue;

/**
 * The type Cousins
 *
 * @author Mohd Nadeem
 */
public class Cousins {
  public static void main(String[] args) {
    TreeNode treeFromArray = AssortedMethods.createTreeFromArray(new int[] {1, 2, 3, 4});
    treeFromArray.print();

    Cousins cousins = new Cousins();
    cousins.isCousins(treeFromArray, 3, 4);
  }

  public boolean isCousins(TreeNode root, int x, int y) {
    int depthX = depth(root, x);
    int depthY = depth(root, y);
    return (depthX == depthY);
  }

  private int depth(TreeNode root, int d) {
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    int depth = 0;
    while (!q.isEmpty()) {
      int size = q.size();
      for (int i = 0; i < size; i++) {
        TreeNode current = q.remove();
        if (current.data == d) {
          return depth;
        }
        if (current.left != null) {
          q.add(current.left);
        }
        if (current.right != null) {
          q.add(current.right);
        }
      }
      depth++;
    }
    return depth;
  }
}
