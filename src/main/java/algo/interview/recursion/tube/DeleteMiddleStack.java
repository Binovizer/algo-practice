package algo.interview.recursion.tube;

import java.util.Stack;

import static algo.interview.utils.CollectionsUtil.generateStack;
import static algo.interview.utils.CollectionsUtil.printStack;

/**
 * This class deletes middle element of the stack
 *
 * @author Nadeem 2020-11-21
 */
public class DeleteMiddleStack {

    public static void main(String[] args) {
        Stack<Integer> stack = generateStack(5, 1, 10);
        printStack(stack);
        DeleteMiddleStack deleteMiddleStack = new DeleteMiddleStack();
        deleteMiddleStack.deleteMiddleElement(stack);
        printStack(stack);
    }

    /**
     * Deletes middle element of the stack
     *
     * @param stack the stack
     */
    private void deleteMiddleElement(Stack<Integer> stack) {
        int k = stack.size() / 2 + 1;
        deleteKthElement(stack, k);
    }

    /**
     * Deletes Kth element from the stack
     *
     * @param stack the stack
     * @param k the k
     */
    private void deleteKthElement(Stack<Integer> stack, int k) {
        if (k == 1) {
            stack.pop();
            return;
        }
        int remaining = stack.pop();
        deleteKthElement(stack, k - 1);
        stack.push(remaining);
    }
}
