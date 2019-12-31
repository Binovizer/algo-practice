package linkedlist;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * The type Union
 *
 * @author Mohd Nadeem
 */
public class Union {

    public LinkedListNode union(LinkedListNode head1, LinkedListNode head2) {
        LinkedListNode result = null;
        Set<Integer> uniques = new HashSet<>();
        while (head1 != null) {
            if (uniques.add(head1.data)) {
                LinkedListNode node = new LinkedListNode(head1.data);
                if (result == null) {
                    result = node;
                } else {
                    node.next = result;
                    result = node;
                }
            }
            head1 = head1.next;
        }
        while (head2 != null) {
            if (uniques.add(head2.data)) {
                LinkedListNode node = new LinkedListNode(head2.data);
                if (result == null) {
                    result = node;
                } else {
                    node.next = result;
                    result = node;
                }
            }
            head2 = head2.next;
        }
        return result;
    }

    public LinkedListNode unionWithSort(LinkedListNode head1, LinkedListNode head2) {
        LinkedListNode result = null;
        Set<Integer> uniques = new TreeSet<>();
        while (head1 != null) {
            uniques.add(head1.data);
            head1 = head1.next;
        }
        while (head2 != null) {
            uniques.add(head2.data);
            head2 = head2.next;
        }
        for (Integer unique : uniques) {
            result = insertAtEnd(result, unique);
        }
        return result;
    }

    private LinkedListNode insertAtEnd(LinkedListNode result, int data) {
        LinkedListNode node = new LinkedListNode(data);
        if (result == null) {
            return node;
        }
        LinkedListNode temp = result;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
        return result;
    }
}
