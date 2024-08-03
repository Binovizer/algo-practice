package algo.practice.v2.daily_coding_problem;

import algo.practice.v2.utils.ListNode;

/**
 * The type P963
 *
 * @author nadeem Date : 14/03/24
 */
public class P963 {

    public ListNode findIntersection(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        // Continue until they either meet or both end at null
        while (a != b) {
            // If either pointer hits the end, switch to the other list's head
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }

        // Either intersection or null
        return a;
    }

    public static void main(String[] args) {
        // Example
        // List A: 3 -> 7 -> 8 -> 10
        ListNode a1 = new ListNode(3);
        ListNode a2 = new ListNode(7);
        ListNode intersect = new ListNode(8);
        ListNode a3 = new ListNode(10);
        a1.next = a2;
        a2.next = intersect;
        intersect.next = a3;

        // List B: 99 -> 1 -> 8 -> 10
        ListNode b1 = new ListNode(99);
        ListNode b2 = new ListNode(1);
        b1.next = b2;
        b2.next = intersect;

        P963 p963 = new P963();
        ListNode intersectionNode = p963.findIntersection(a1, b1);
        if (intersectionNode != null) {
            System.out.println("Intersection at node with value: " + intersectionNode.val);
        } else {
            System.out.println("No intersection found.");
        }
    }
}
