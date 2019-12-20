package tree;

import utils.AssortedMethods;

import java.util.Map;
import java.util.TreeMap;

/**
 * The type TopView
 *
 * @author Mohd Nadeem
 */
public class TopView {

  private static Map<Integer, Integer> map = new TreeMap<>();

  public static void main(String[] args) {
    TreeNode root = AssortedMethods.createTreeFromArray(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9});
    root.print();

    TopView topView = new TopView();
    topView.printTopView(root);
  }

  private void printTopView(TreeNode root) {
    printTopView(root, 0);
    System.out.println(map);
  }

  private void printTopView(TreeNode root, int hd) {
    if (root == null) {
      return;
    }
    printTopView(root.left, hd - 1);
    printTopView(root.right, hd + 1);
    map.put(hd, root.data);
  }
}
