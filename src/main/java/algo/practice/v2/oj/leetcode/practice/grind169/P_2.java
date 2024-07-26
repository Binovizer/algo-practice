package algo.practice.v2.oj.leetcode.practice.grind169;

/**
 * The type P_2
 *
 * @author nadeem Date : 20/07/24
 */
public class P_2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode tail = head;

        int carry = 0;
        while (l1 != null || l2 != null) {
            int first = l1 != null ? l1.val : 0;
            int second = l2 != null ? l2.val : 0;
            int sum = first + second + carry;
            carry = sum / 10;
            int digit = sum % 10;

            tail.next = new ListNode(digit);
            tail = tail.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (carry != 0) {
            tail.next = new ListNode(carry);
            tail = tail.next;
        }

        return head.next;
    }
}
