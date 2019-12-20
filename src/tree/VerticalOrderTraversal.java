package tree;

import utils.AssortedMethods;

import java.util.*;

/**
 * The type LevelOrderTraversal
 *
 * @author Mohd Nadeem
 */
public class VerticalOrderTraversal {

  private static Map<Integer, List<Integer>> map = new TreeMap<>();

  public static void main(String[] args) {
    TreeNode root = AssortedMethods.createTreeFromArray(new int[] {1, 2, 3, 4, 5, 6, 7});
    root.print();

    VerticalOrderTraversal verticalOrderTraversal = new VerticalOrderTraversal();
    //        verticalOrderTraversal.traverse(root);
    verticalOrderTraversal.traverseRecursive(root, 0);
    for (Integer key : map.keySet()) {
      List<Integer> elements = map.get(key);
      for (Integer element : elements) {
        System.out.print(element + " ");
      }
    }
  }

  private void traverse(TreeNode root) {}

  private void traverseRecursive(TreeNode root, int hd) {
    if (root == null) {
      return;
    }
    List<Integer> elements = map.get(hd);
    if (Objects.isNull(elements)) {
      elements = new ArrayList<>();
    }
    elements.add(root.data);
    map.put(hd, elements);

    traverseRecursive(root.left, hd - 1);
    traverseRecursive(root.right, hd + 1);
  }
}
