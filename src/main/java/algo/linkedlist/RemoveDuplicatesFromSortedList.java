package algo.linkedlist;

import java.util.Objects;

/**
 * The type RemoveDuplicatesFromSortedList
 *
 * @author Mohd Nadeem
 */
public class RemoveDuplicatesFromSortedList {

    public static void main(String[] args) {
        LinkedListNode linkedListNode = new LinkedListNode(1);
        linkedListNode.next = new LinkedListNode(1);
        linkedListNode.next.next = new LinkedListNode(1);
        linkedListNode.next.next.next = new LinkedListNode(2);
        linkedListNode.next.next.next.next = new LinkedListNode(2);
        linkedListNode.next.next.next.next.next = new LinkedListNode(3);
        linkedListNode.next.next.next.next.next.next = new LinkedListNode(3);
        System.out.println("linkedListNode = " + linkedListNode.printForward());
        RemoveDuplicatesFromSortedList removeDuplicatesFromSortedList =
                new RemoveDuplicatesFromSortedList();
        LinkedListNode noDups = removeDuplicatesFromSortedList.removeDuplicates(linkedListNode);
        if (Objects.nonNull(noDups)) {
            System.out.println("noDups = " + noDups.printForward());
        } else {
            System.out.println("Empty list");
        }
    }

    LinkedListNode removeDuplicates(LinkedListNode A) {
        if (A == null) return A;
        LinkedListNode curr = A, prev = null, next;
        LinkedListNode newList = new LinkedListNode(-1), new_head = newList;
        while (curr != null) {
            next = curr.next;
            if (!((prev != null && curr.data == prev.data)
                    || (next != null && curr.data == next.data))) {
                LinkedListNode n = new LinkedListNode(curr.data);
                newList.next = n;
                newList = n;
            }
            prev = curr;
            curr = next;
        }
        return new_head.next;
    }
}
