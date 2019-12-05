package linkedlist;

/**
 * The type SegregateEvenOdd
 *
 * @author Mohd Nadeem
 */
public class SegregateEvenOdd {

    public LinkedListNode segregate(LinkedListNode head){
        if(head == null || head.next == null){
            return head;
        }
        LinkedListNode temp = head.next;
        LinkedListNode pre = head;
        while (temp != null){
            LinkedListNode next = temp.next;
            if(temp.data % 2 == 0){
                pre.next = temp.next;
                temp.next = head;
                head = temp;
            }else{
                pre = temp;
            }
            temp = next;
        }
        return head;
    }
}
