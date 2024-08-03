package algo.practice.v2.utils;

/**
 * This is the description of what this type does
 *
 * @author Nadeem 2020-12-24
 */
public class CommonUtil {

    /**
     * Creates linked list from array
     *
     * @param values the value array
     * @return the linked list head
     */
    public static ListNode createLinkedListFromArray(int[] values) {
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for (int i = 1; i < values.length; i++) {
            ListNode newNode = new ListNode(values[i]);
            current.next = newNode;
            current = newNode;
        }
        return head;
    }
}
