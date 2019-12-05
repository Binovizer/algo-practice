package linkedlist;

/**
 * The type Partition
 *
 * @author Mohd Nadeem
 */
public class Partition {

    public LinkedListNode partition(LinkedListNode head, int x){
        LinkedListNode tail = head;
        LinkedListNode current = head;
        while (current != null){
            LinkedListNode next = current.next;
            if(current.data < x){
                current.next = head;
                head = current;
            }else{
                tail.next = current;
                tail = current;
            }
            current = next;
        }
        tail.next = null;
        return head;
    }
}
