package algo.linkedlist;

/**
 * The type DeleteMiddleNode
 *
 * @author Mohd Nadeem
 */
public class DeleteMiddleNode {

    public void deleteMiddle(LinkedListNode head) {
        LinkedListNode slow = head;
        LinkedListNode fast = head;
        LinkedListNode pre = null;
        while (fast.next != null && fast.next.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (pre != null) {
            pre.next = slow.next;
        }
    }
}
