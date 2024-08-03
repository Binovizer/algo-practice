package algo.practice.v1.linkedlist;

/**
 * The type KthToLast
 *
 * @author Mohd Nadeem
 */
public class KthToLast {

    public int printKthToLast(LinkedListNode head, int k) {
        Index idx = new Index();
        LinkedListNode listNode = printKthToLast(head, k, idx);
        return listNode == null ? -1 : listNode.data;
    }

    public int printKthToLastIterative(LinkedListNode head, int k) {
        LinkedListNode listNode = printKthToLastIter(head, k);
        return listNode == null ? -1 : listNode.data;
    }

    private LinkedListNode printKthToLast(LinkedListNode head, int k, Index index) {
        if (head == null) {
            return null;
        }
        LinkedListNode node = printKthToLast(head.next, k, index);
        index.value = index.value + 1;
        if (index.value == k) {
            return head;
        }
        return node;
    }

    private LinkedListNode printKthToLastIter(LinkedListNode head, int k) {
        LinkedListNode p1 = head;
        LinkedListNode p2 = head;
        for (int i = 0; i < k; i++) {
            if (p1 == null) {
                return null;
            }
            p1 = p1.next;
        }
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }

    class Index {
        public int value = 0;
    }
}
