package algo.practice.v2.platforms.leetcode.challenges.jan.week1;

import algo.practice.v2.utils.CommonUtil;
import algo.practice.v2.utils.ListNode;

/**
 * This is the description of what this type does
 *
 * @author Nadeem 2021-01-05
 */
public class RemoveDuplicatesFromSortedListII {

    public static void main(String[] args) {
        ListNode head = CommonUtil.createLinkedListFromArray(new int[] {1, 2, 3, 3, 4, 4, 5});
        RemoveDuplicatesFromSortedListII removeDuplicatesFromSortedListII =
                new RemoveDuplicatesFromSortedListII();
        ListNode uniqueList = removeDuplicatesFromSortedListII.deleteDuplicates(head);
        System.out.println(uniqueList.printForward());
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode sentinel = new ListNode(0);
        ListNode pred = sentinel;
        while (head != null) {
            if (head.next != null && head.val == head.next.val) {
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                pred.next = head.next;
            } else {
                pred.next = head;
                pred = pred.next;
            }
            head = head.next;
        }
        return sentinel.next;
    }
}
