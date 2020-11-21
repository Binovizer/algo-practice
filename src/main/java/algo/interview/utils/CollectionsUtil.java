package algo.interview.utils;

import java.util.Random;
import java.util.Stack;

/**
 * This is the description of what this type does
 *
 * @author Nadeem 2020-11-21
 */
public class CollectionsUtil {


    /**
     * Prints stack elements
     *
     * @param stack the stack
     */
    public static void printStack(Stack<Integer> stack) {
        System.out.print("Stack ::: ");
        for (int i = stack.size()-1; i >= 0; i--) {
            System.out.print(stack.get(i) + " ");
        }
        System.out.println();
    }


    /**
     * Generates a stack of given size with given range
     *
     * @param noOfElements the size of the stack
     * @param inclusiveStart the inclusiveStart of the range
     * @param exclusiveEnd the exclusiveEnd of the range
     * @return the stack
     */
    public static Stack<Integer> generateStack(int noOfElements, int inclusiveStart, int exclusiveEnd) {
        Stack<Integer> stack = new Stack<>();
        Random random = new Random();
        while (noOfElements-- > 0) {
            stack.push(random.nextInt(exclusiveEnd - inclusiveStart) + inclusiveStart);
        }
        return stack;
    }
}
