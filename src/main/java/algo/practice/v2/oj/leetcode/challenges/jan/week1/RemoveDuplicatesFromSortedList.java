package algo.practice.v2.oj.leetcode.challenges.jan.week1;

import algo.practice.v2.utils.CommonUtil;
import algo.practice.v2.utils.ListNode;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 *
 * @author Nadeem 2021-01-05
 */
public class RemoveDuplicatesFromSortedList {

    public static void main(String[] args) {
        ListNode head = CommonUtil.createLinkedListFromArray(new int[] {1, 2, 3, 3, 4, 4, 5});
        RemoveDuplicatesFromSortedList removeDuplicatesFromSortedListII =
                new RemoveDuplicatesFromSortedList();
        ListNode uniqueList = removeDuplicatesFromSortedListII.deleteDuplicates(head);
        System.out.println(uniqueList.printForward());
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = new ListNode(-1001);
        ListNode curr = head;
        while (curr != null) {
            if (prev.val == curr.val) {
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
        return head;
    }
}
