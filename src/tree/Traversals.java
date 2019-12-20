package tree;

import java.util.LinkedList;
import java.util.Queue;

public class Traversals {
  public static void visit(TreeNode node) {
    if (node != null) {
      System.out.print(node.data + " ");
    }
  }

  public static void inOrderTraversal(TreeNode node) {
    if (node != null) {
      inOrderTraversal(node.left);
      visit(node);
      inOrderTraversal(node.right);
    }
  }

  public static void preOrderTraversal(TreeNode node) {
    if (node != null) {
      visit(node);
      preOrderTraversal(node.left);
      preOrderTraversal(node.right);
    }
  }

  public static void postOrderTraversal(TreeNode node) {
    if (node != null) {
      postOrderTraversal(node.left);
      postOrderTraversal(node.right);
      visit(node);
    }
  }

  public static void levelOrderTraversal(TreeNode node) {
    System.out.print("Level Order Traversal : ");
    Queue<TreeNode> q = new LinkedList<>();
    if (node != null) {
      q.add(node);
    }
    while (!q.isEmpty()) {
      TreeNode poll = q.poll();
      visit(poll);
      if (poll.left != null) {
        q.add(poll.left);
      }
      if (poll.right != null) {
        q.add(poll.right);
      }
    }
  }

  public static void main(String[] args) {
    int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    // We needed this code for other files, so check out the code in the library
    TreeNode root = TreeNode.createMinimalBST(array);
    root.print();
    levelOrderTraversal(root);
  }
}
