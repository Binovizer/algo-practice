package algo.interview.recursion.tube;

import java.util.Stack;

import static algo.interview.utils.CollectionsUtil.generateStack;
import static algo.interview.utils.CollectionsUtil.printStack;

/**
 * This class reverses the stack
 *
 * @author Nadeem 2020-11-21
 */
public class ReverseStack {

    public static void main(String[] args) {
        Stack<Integer> stack = generateStack(5, 1, 10);
        printStack(stack);
        ReverseStack reverseStack = new ReverseStack();
        reverseStack.reverse(stack);
        printStack(stack);
    }

    /**
     * Reverses the stack
     *
     * @param stack the stack
     */
    private void reverse(Stack<Integer> stack) {
        if(stack.size() == 1){
            return;
        }
        int remaining = stack.pop();
        reverse(stack);
        insertAtEnd(stack, remaining);
    }

    /**
     * Inserts the given element to the end of given stack
     *
     * @param stack the stack
     * @param element the element
     */
    private void insertAtEnd(Stack<Integer> stack, int element) {
        if(stack.size() == 0){
            stack.push(element);
            return;
        }
        int remaining = stack.pop();
        insertAtEnd(stack, element);
        stack.push(remaining);
    }
}
