package tree;

import utils.AssortedMethods;

/**
 * The type MirrorTree
 *
 * @author Mohd Nadeem
 */
public class MirrorTree {

  public static void main(String[] args) {
    TreeNode treeFromArray = AssortedMethods.createTreeFromArray(new int[] {1, 3, 2, 4, 5, 6});
    treeFromArray.print();

    MirrorTree mirrorTree = new MirrorTree();
    TreeNode mirror = mirrorTree.mirror(treeFromArray);
    mirror.print();

    boolean isMirror = mirrorTree.isMirror(treeFromArray, mirror);
    System.out.println("isMirror = " + isMirror);
  }

  TreeNode mirror(TreeNode root) {
    if (root == null) {
      return root;
    }
    TreeNode left = mirror(root.left);
    root.left = mirror(root.right);
    root.right = left;
    return root;
  }

  boolean isMirror(TreeNode tree1, TreeNode tree2) {
    if (tree1 == null && tree2 == null) {
      return true;
    }
    if (tree1 == null || tree2 == null) {
      return false;
    }
    return (tree1.data == tree2.data)
        && isMirror(tree1.left, tree2.left)
        && isMirror(tree1.right, tree2.right);
  }
}
