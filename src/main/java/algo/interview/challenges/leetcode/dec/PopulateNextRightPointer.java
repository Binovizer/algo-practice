package algo.interview.challenges.leetcode.dec;

/**
 * This is the description of what this type does
 *
 * @author Nadeem 2020-12-08
 */
public class PopulateNextRightPointer {

    public void connect(TreeLinkNode root) {
        TreeLinkNode head = root; // The left most node in the lower level
        TreeLinkNode prev; // The previous node in the lower level
        TreeLinkNode curr; // The current node in the upper level
        while (head != null) {
            curr = head;
            prev = null;
            head = null;
            while (curr != null) {
                if (curr.left != null) {
                    if (prev != null) prev.next = curr.left;
                    else head = curr.left;
                    prev = curr.left;
                }
                if (curr.right != null) {
                    if (prev != null) prev.next = curr.right;
                    else head = curr.right;
                    prev = curr.right;
                }
                curr = curr.next;
            }
        }
    }

    static class TreeLinkNode {
        int val;
        TreeLinkNode left;
        TreeLinkNode right;
        TreeLinkNode next;
    }
}
