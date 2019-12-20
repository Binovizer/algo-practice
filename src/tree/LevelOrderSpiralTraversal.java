package tree;

import utils.AssortedMethods;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * The type LevelOrderSpiralTraversal
 *
 * @author Mohd Nadeem
 */
public class LevelOrderSpiralTraversal {

  public static void main(String[] args) {
    TreeNode root = AssortedMethods.createTreeFromArray(new int[] {1, 2, 3, 7, 6, 5, 4});
    root.print();

    LevelOrderSpiralTraversal levelOrderSpiralTraversal = new LevelOrderSpiralTraversal();
    levelOrderSpiralTraversal.traverse(root);
  }

  private void traverse(TreeNode root) {
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    boolean fromLeft = false;
    while (!q.isEmpty()) {
      int size = q.size();
      Stack<Integer> level = new Stack<>();
      for (int i = 0; i < size; i++) {
        TreeNode poll = q.poll();
        if (fromLeft) {
          System.out.print(poll.data + " ");
        } else {
          level.push(poll.data);
        }

        if (poll.left != null) {
          q.offer(poll.left);
        }
        if (poll.right != null) {
          q.offer(poll.right);
        }
      }
      if (!fromLeft) {
        while (!level.empty()) {
          int pop = level.pop();
          System.out.print(pop + " ");
        }
      }
      fromLeft = !fromLeft;
    }
    System.out.println();
  }
}
