package linkedlist;

import utils.AssortedMethods;

/**
 * The type DetectLoop
 *
 * @author Mohd Nadeem
 */
public class DetectLoop {

    public static void main(String[] args) {
        LinkedListNode head = AssortedMethods.createLinkedListFromArray(new int[]{1, 2, 3, 4, 5});

        DetectLoop detectLoop = new DetectLoop();
        boolean haveLoop = detectLoop.detectLoop(head);
        System.out.println("haveLoop = " + haveLoop);
    }

    private boolean detectLoop(LinkedListNode head) {
        if(head == null){
            return false;
        }
        LinkedListNode slowPtr = head;
        LinkedListNode fastPtr = head;
        while(fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if(slowPtr == fastPtr){
                return true;
            }
        }
        return false;
    }
}
