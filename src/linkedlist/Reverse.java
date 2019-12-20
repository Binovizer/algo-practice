package linkedlist;

import utils.AssortedMethods;

/**
 * The type Reverse
 *
 * @author Mohd Nadeem
 */
public class Reverse {

  public static void main(String[] args) {
    //        LinkedListNode list = AssortedMethods.createLinkedListFromArray(new int[]{1, 2, 3, 4,
    // 5});
    //        System.out.println(list.printForward());
    //
    Reverse reverse = new Reverse();
    //
    //        LinkedListNode reversed = reverse.reverse(list);
    //        System.out.println(reversed.printForward());

    LinkedListNode list2 =
        AssortedMethods.createLinkedListFromArray(new int[] {1, 2, 3, 4, 5, 6, 7});
    LinkedListNode reverseInGroups = reverse.reverseInGroups(list2, 3);
    System.out.println(reverseInGroups.printForward());
  }

  public LinkedListNode reverse(LinkedListNode head) {
    LinkedListNode current = head;
    LinkedListNode pre = null;
    while (current != null) {
      LinkedListNode next = current.next;

      current.next = pre;

      pre = current;
      current = next;
    }
    return pre;
  }

  public LinkedListNode reverseInGroups(LinkedListNode head, int groupSize) {
    LinkedListNode current = head;
    LinkedListNode pre = null;
    LinkedListNode next = null;
    int count = 0;
    while (current != null && count < groupSize) {
      next = current.next;

      current.next = pre;

      pre = current;
      current = next;

      count++;
    }
    if (next != null) {
      head.next = reverseInGroups(next, groupSize);
    }
    return pre;
  }
}
