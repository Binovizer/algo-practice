package algo.practice.v2.oj.leetcode.practice.grind169;

/**
 * The type P_19
 *
 * @author nadeem Date : 26/07/24
 */
public class P_19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head, slow = head;
        for (int i = 0; i < n; i++) fast = fast.next;
        if (fast == null) return head.next;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
