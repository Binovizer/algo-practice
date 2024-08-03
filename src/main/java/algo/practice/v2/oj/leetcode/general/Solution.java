package algo.practice.v2.oj.leetcode.general;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] descriptions = {{20, 15, 1}, {20, 17, 0}, {50, 20, 1}, {50, 80, 0}, {80, 19, 1}};
        TreeNode treeNode = solution.createBinaryTree(descriptions);
        System.out.println(treeNode);
    }

    public TreeNode createBinaryTree(int[][] descriptions) {
        Set<Integer> hasParent = new HashSet<>();

        Map<Integer, TreeNode> map = new HashMap<>();
        for (int[] desc : descriptions) {
            int parent = desc[0];
            int child = desc[1];
            int isLeft = desc[2];

            TreeNode childNode = map.getOrDefault(child, new TreeNode(child));
            map.putIfAbsent(child, childNode);
            hasParent.add(child);

            TreeNode parentNode = map.getOrDefault(parent, new TreeNode(parent));
            map.putIfAbsent(parent, parentNode);
            if (isLeft == 1) {
                parentNode.left = childNode;
            } else {
                parentNode.right = childNode;
            }
        }

        for (Integer key : map.keySet()) {
            if (!hasParent.contains(key)) return map.get(key);
        }
        return null;
    }
}
