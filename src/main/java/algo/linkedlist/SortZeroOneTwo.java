package algo.linkedlist;

/**
 * The type SortZeroOneTwo
 *
 * @author Mohd Nadeem
 */
public class SortZeroOneTwo {

    public LinkedListNode sort(LinkedListNode head) {
        LinkedListNode dummyZero = new LinkedListNode(-1);
        LinkedListNode dummyOne = new LinkedListNode(-1);
        LinkedListNode dummyTwo = new LinkedListNode(-1);

        LinkedListNode zero = dummyZero;
        LinkedListNode one = dummyOne;
        LinkedListNode two = dummyTwo;

        LinkedListNode current = head;
        while (current != null) {
            LinkedListNode next = current.next;
            if (current.data == 0) {
                zero.next = current;
                zero = current;
            } else if (current.data == 1) {
                one.next = current;
                one = current;
            } else {
                two.next = current;
                two = current;
            }
            current = next;
        }
        zero.next = dummyZero.next != null ? dummyOne.next : dummyTwo.next;
        one.next = dummyTwo.next;
        two.next = null;

        return dummyZero.next;
    }
}
