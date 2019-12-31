package linkedlist;

import utils.AssortedMethods;

import java.util.ArrayList;
import java.util.Collections;

/**
 * The type ZigZagList
 *
 * @author Mohd Nadeem
 */
public class ZigZagList {

    public static void main(String[] args) {
        LinkedListNode list =
                AssortedMethods.createLinkedListFromArray(new int[] {11, 15, 20, 5, 10});
        System.out.println("list = " + list.printForward());

        ZigZagList zigZagList = new ZigZagList();
        //    LinkedListNode zigZagHead = zigZagList.rearrange(list);
        zigZagList.rearrangeOptimized(list);
        System.out.println("zigZagHead = " + list.printForward());
    }

    private LinkedListNode rearrange(LinkedListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.data);
            head = head.next;
        }
        Collections.sort(list);
        for (int i = 1; i < list.size() - 1; i = i + 2) {
            Integer temp = list.get(i);
            list.set(i, list.get(i + 1));
            list.set(i + 1, temp);
        }
        LinkedListNode start = null;
        LinkedListNode lastInserted = null;
        for (int i = 0; i < list.size(); i++) {
            LinkedListNode node = new LinkedListNode(list.get(i));
            if (start == null) {
                start = node;
                lastInserted = node;
            } else {
                lastInserted.next = node;
                lastInserted = node;
            }
        }
        return start;
    }

    private void rearrangeOptimized(LinkedListNode head) {
        if (head == null) return;
        LinkedListNode temp = head.next;
        LinkedListNode prev = head;
        int count = 0;
        while (temp != null) {
            if (count == 0) {
                if (temp.data < prev.data) {
                    swap(temp, prev);
                }
                count++;
            } else {
                if (temp.data > prev.data) {
                    swap(temp, prev);
                }
                count--;
            }
            temp = temp.next;
            prev = prev.next;
        }
        LinkedListNode k = head;
        while (k != null) {
            System.out.print(k.data + " ");
            k = k.next;
        }
        System.out.println();
    }

    private void swap(LinkedListNode a, LinkedListNode b) {
        int p = a.data;
        a.data = b.data;
        b.data = p;
    }
}
