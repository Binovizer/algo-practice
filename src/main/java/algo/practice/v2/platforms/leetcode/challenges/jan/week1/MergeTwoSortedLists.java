package algo.practice.v2.platforms.leetcode.challenges.jan.week1;

import algo.practice.v2.utils.CommonUtil;
import algo.practice.v2.utils.ListNode;

/**
 * This is the description of what this type does
 *
 * @author Nadeem 2021-01-04
 */
public class MergeTwoSortedLists {

    public static void main(String[] args) {
        ListNode l1 = CommonUtil.createLinkedListFromArray(new int[] {1, 3, 5});
        ListNode l2 = CommonUtil.createLinkedListFromArray(new int[] {2, 4, 6});
        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
        ListNode listNode = mergeTwoSortedLists.mergeTwoLists(l1, l2);
        System.out.println(listNode.printForward());
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public ListNode mergeTwoListsIterative(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode dummyHead = new ListNode(-1);
        ListNode end = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                end.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                end.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            end = end.next;
        }
        while (l1 != null) {
            end.next = new ListNode(l1.val);
            end = end.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            end.next = new ListNode(l2.val);
            end = end.next;
            l2 = l2.next;
        }
        return dummyHead.next;
    }
}
