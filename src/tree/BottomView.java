package tree;

import utils.AssortedMethods;

import java.util.HashMap;

/**
 * The type TopView
 *
 * @author Mohd Nadeem
 */
public class BottomView {

    public static void main(String[] args) {
        TreeNode root = AssortedMethods.createTreeFromArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        root.print();

        BottomView bottomView = new BottomView();
        bottomView.printBottomView(root);
    }

    private void printBottomView(TreeNode root) {
        printBottomView(root, 0);
        System.out.println(map);
    }

    private static HashMap<Integer, Integer> map = new HashMap<>();

    private void printBottomView(TreeNode root, int hd) {
        if(root == null){
            return;
        }
        printBottomView(root.left, hd - 1);
        if(! map.containsKey(hd)){
            System.out.println(root.data);
            map.put(hd, root.data);
        }
        printBottomView(root.right, hd + 1);
    }
}
