package algo.practice.v2.platforms.leetcode.challenges.dec.week4;

import algo.practice.v2.utils.CommonUtil;
import algo.practice.v2.utils.ListNode;

/**
 * This is the description of what this type does
 *
 * @author Nadeem 2020-12-24
 */
public class SwapNodesInPairs {

    public static void main(String[] args) {
        ListNode head = CommonUtil.createLinkedListFromArray(new int[] {1, 2, 3, 4});
        SwapNodesInPairs swapNodesInPairs = new SwapNodesInPairs();
        ListNode listNode = swapNodesInPairs.swapPairs(head);
        System.out.println(listNode.printForward());
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode first = head;
        ListNode second = head.next;
        ListNode remaining = head.next.next;
        head = second;
        head.next = first;
        head.next.next = swapPairs(remaining);
        return head;
    }
}
