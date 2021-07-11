package algo.practice.v2.oj.leetcode.challenges.jan.week1;

import algo.practice.v2.utils.CommonUtil;
import algo.practice.v2.utils.ListNode;

/**
 * https://leetcode.com/problems/sort-list/
 *
 * @author Nadeem 2021-01-04
 */
public class SortList {

    public static void main(String[] args) {
        ListNode list = CommonUtil.createLinkedListFromArray(new int[] {1, 3, 2, 5, 4});
        SortList sortList = new SortList();
        ListNode listNode = sortList.sortList(list);
        System.out.println(listNode.printForward());
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode middle = getMiddleNode(head);
        ListNode nextOfMiddle = middle.next;

        // Separate both lists by breaking the list
        middle.next = null;

        ListNode firstPart = sortList(head);
        ListNode secondPart = sortList(nextOfMiddle);
        return merge(firstPart, secondPart);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val <= l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }

    private ListNode getMiddleNode(ListNode node) {
        ListNode slow = node;
        ListNode fast = node;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
