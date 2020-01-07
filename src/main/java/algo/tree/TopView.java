package algo.tree;

import algo.utils.AssortedMethods;

import java.util.Map;
import java.util.Stack;
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
        //        System.out.println(map);
        for (Integer i : map.keySet()) {
            System.out.print(map.get(i) + " ");
        }
        System.out.println();
    }

    private void printTopView(TreeNode root, int hd) {
        if (root == null) {
            return;
        }
        printTopView(root.left, hd - 1);
        printTopView(root.right, hd + 1);
        map.put(hd, root.data);
    }

    void topView(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root.left;
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop().data + " ");
        }
        System.out.print(root.data + " ");
        cur = root.right;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.right;
        }
    }

    void printLeft(TreeNode root) {
        if (root == null) return;
        printLeft(root.left);
        System.out.print(root.data + " ");
    }

    void printRight(TreeNode root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        printRight(root.right);
    }

    void topViewRecursive(TreeNode root) {
        printLeft(root.left);
        System.out.print(root.data + " ");
        printRight(root.right);
    }
}
