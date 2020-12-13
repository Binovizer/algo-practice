package algo.practice.v1.linkedlist;

/**
 * The type DeleteMiddleNode
 *
 * @author Mohd Nadeem
 */
public class DeleteMiddleNode {

    public void deleteMiddle(LinkedListNode head) {
        LinkedListNode slow = head;
        LinkedListNode fast = head;
        LinkedListNode prev = null;
        while (fast.next != null && fast.next.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (prev != null) {
            prev.next = slow.next;
        }
    }
}
