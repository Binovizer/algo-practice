package algo.practice.v1.linkedlist;

import algo.practice.v1.utils.AssortedMethods;

/**
 * The type MergeTwoSortedLists
 *
 * @author Mohd Nadeem
 */
public class MergeTwoSortedLists {

    public static void main(String[] args) {
        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
        LinkedListNode l1 = AssortedMethods.createLinkedListFromArray(new int[] {1, 2, 4});
        LinkedListNode l2 = AssortedMethods.createLinkedListFromArray(new int[] {1, 3, 4});
        LinkedListNode ans = mergeTwoSortedLists.mergeTwoLists(l1, l2);
        System.out.println("Merged List = " + ans.printForward());
    }

    public LinkedListNode mergeTwoLists(LinkedListNode l1, LinkedListNode l2) {
        LinkedListNode node = new LinkedListNode(-1);
        LinkedListNode ans = node;
        while (l1 != null && l2 != null) {
            if (l1.data >= l2.data) {
                node.next = new LinkedListNode(l2.data);
                node = node.next;
                l2 = l2.next;
            } else {
                node.next = new LinkedListNode(l1.data);
                node = node.next;
                l1 = l1.next;
            }
        }
        while (l1 != null) {
            node.next = new LinkedListNode(l1.data);
            node = node.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            node.next = new LinkedListNode(l2.data);
            node = node.next;
            l2 = l2.next;
        }
        return ans.next;
    }
}
