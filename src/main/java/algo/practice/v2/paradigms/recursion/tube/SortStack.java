package algo.practice.v2.paradigms.recursion.tube;

import java.util.Stack;

import static algo.practice.v2.utils.CollectionsUtil.generateStack;
import static algo.practice.v2.utils.CollectionsUtil.printStack;

/**
 * This class sorts the stack
 *
 * @author Nadeem 2020-11-21
 */
public class SortStack {

    public static void main(String[] args) {
        Stack<Integer> stack = generateStack(5, 1, 6);
        printStack(stack);
        SortStack sortStack = new SortStack();
        sortStack.sortStack(stack);
        printStack(stack);
    }

    /**
     * Sorts the stack
     *
     * @param stack the stack
     */
    public void sortStack(Stack<Integer> stack) {
        // Base Case
        if (stack.size() == 1) {
            return;
        }
        int lastElement = stack.pop();
        sortStack(stack);
        insert(stack, lastElement);
    }

    /**
     * Inserts the given element to its proper position in stack
     *
     * @param stack the stack
     * @param element the element
     */
    private void insert(Stack<Integer> stack, int element) {
        if (stack.size() == 0 || stack.peek() <= element) {
            stack.push(element);
            return;
        }
        int remaining = stack.pop();
        insert(stack, element);
        stack.push(remaining);
    }
}
