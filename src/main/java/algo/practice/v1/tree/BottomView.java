package algo.practice.v1.tree;

import algo.practice.v1.utils.AssortedMethods;

import java.util.Map;
import java.util.TreeMap;

/**
 * The type TopView
 *
 * @author Mohd Nadeem
 */
public class BottomView {

    private static Map<Integer, Integer> map = new TreeMap<>();

    public static void main(String[] args) {
        TreeNode root = AssortedMethods.createTreeFromArray(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9});
        root.print();

        BottomView bottomView = new BottomView();
        bottomView.printBottomViewRightNode(root);
    }

    private void printBottomViewRightNode(TreeNode root) {
        printBottomViewLeftNode(root, 0);
        //        printBottomViewRightNode(root, 0);
        System.out.println(map);
    }

    private void printBottomViewLeftNode(TreeNode root, int hd) {
        if (root == null) {
            return;
        }
        printBottomViewLeftNode(root.left, hd - 1);
        if (!map.containsKey(hd)) {
            System.out.print(root.data + " ");
            map.put(hd, root.data);
        }
        printBottomViewLeftNode(root.right, hd + 1);
    }

    private void printBottomViewRightNode(TreeNode root, int hd) {
        if (root == null) {
            return;
        }
        printBottomViewRightNode(root.right, hd + 1);
        if (!map.containsKey(hd)) {
            map.put(hd, root.data);
        }
        printBottomViewRightNode(root.left, hd - 1);
    }
}
