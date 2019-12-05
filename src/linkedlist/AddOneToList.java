package linkedlist;

import java.util.Stack;

/**
 * The type AddOneToList
 *
 * @author Mohd Nadeem
 */
public class AddOneToList {

    public LinkedListNode addOne(LinkedListNode head){
        LinkedListNode ans = null;
        Stack<Integer> stack = new Stack<>();
        LinkedListNode temp = head;
        while(temp != null){
            stack.push(temp.data);
            temp = temp.next;
        }
        int carry = 1;
        while(! stack.empty()){
            int pop = stack.pop();
            int d = (pop + carry) % 10;
            carry = (pop + carry) / 10;
            LinkedListNode node = new LinkedListNode(d);
            if(ans != null) {
                node.next = ans;
            }
            ans = node;
        }
        if(carry != 0){
            LinkedListNode node = new LinkedListNode(carry);
            node.next = ans;
            ans = node;
        }
        return ans;
    }
}
