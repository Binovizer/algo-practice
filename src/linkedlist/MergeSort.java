package linkedlist;

/**
 * The type MergeSort
 *
 * @author Mohd Nadeem
 */
public class MergeSort {

    public LinkedListNode sort(LinkedListNode head){
        if(head == null || head.next == null){
            return head;
        }
        LinkedListNode middle = getMiddleNode(head);
        LinkedListNode middleNext = middle.next;
        middle.next = null;
        LinkedListNode left = sort(head);
        LinkedListNode right = sort(middleNext);
        return merge(left, right);
    }

    private LinkedListNode merge(LinkedListNode a, LinkedListNode b) {
        LinkedListNode sorted;
        if(a == null){
            return b;
        }
        if(b == null){
            return a;
        }
        if(a.data <= b.data){
            sorted = a;
            sorted.next = merge(a.next, b);
        }else{
            sorted = b;
            sorted.next = merge(a, b.next);
        }
        return sorted;
    }

    private LinkedListNode getMiddleNode(LinkedListNode head){
        LinkedListNode slow = head;
        LinkedListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
