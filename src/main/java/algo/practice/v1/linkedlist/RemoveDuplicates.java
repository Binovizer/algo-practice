package algo.practice.v1.linkedlist;

import algo.practice.v1.utils.AssortedMethods;

import java.util.HashSet;
import java.util.Set;

/**
 * The type RemoveDuplicates
 *
 * @author Mohd Nadeem
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        LinkedListNode list =
                AssortedMethods.createLinkedListFromArray(new int[] {1, 2, 2, 2, 3, 4, 4, 5});
        System.out.println("list = " + list.printForward());

        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        LinkedListNode head = removeDuplicates.removeDuplicatesFromSortedList(list);
        System.out.println("head = " + head.printForward());
    }

    public void removeDuplicates(LinkedListNode head) {
        Set<Integer> uniques = new HashSet<>();
        while (head != null) {
            if (uniques.contains(head.data)) {
                if (head.next != null) {
                    head.next.prev = head.prev;
                }
                head.prev.next = head.next;
            } else {
                uniques.add(head.data);
            }
            head = head.next;
        }
    }

    public LinkedListNode removeDuplicatesFromSortedList(LinkedListNode head) {
        LinkedListNode pre = null;
        LinkedListNode curr = head;
        while (curr != null) {
            LinkedListNode next = curr.next;
            if (pre != null && pre.data == curr.data) {
                pre.next = next;
            } else {
                pre = curr;
            }
            curr = curr.next;
        }
        return head;
    }
}
