package algo.practice.v2.utils;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {}

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public String printForward() {
        if (next != null) {
            return val + "->" + next.printForward();
        } else {
            return ((Integer) val).toString();
        }
    }
}
