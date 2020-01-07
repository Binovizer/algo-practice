package algo.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * The type StackUsingQueues
 *
 * @author Mohd Nadeem
 */
public class StackUsingTwoQueues {

    private final Queue<Integer> q1;
    private final Queue<Integer> q2;

    public StackUsingTwoQueues() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public static void main(String[] args) {
        StackUsingTwoQueues stackUsingTwoQueues = new StackUsingTwoQueues();
        stackUsingTwoQueues.push(1);
        stackUsingTwoQueues.push(2);
        stackUsingTwoQueues.push(3);
        Integer pop = stackUsingTwoQueues.pop();
        System.out.println("pop1 = " + pop);
        stackUsingTwoQueues.push(4);
        stackUsingTwoQueues.push(5);
        System.out.println("pop2 = " + stackUsingTwoQueues.pop());
        System.out.println("pop2 = " + stackUsingTwoQueues.pop());
        System.out.println("pop2 = " + stackUsingTwoQueues.pop());
        System.out.println("pop2 = " + stackUsingTwoQueues.pop());
    }

    public void push(Integer num) {
        while (!q1.isEmpty()) {
            Integer poll = q1.poll();
            q2.offer(poll);
        }
        q1.offer(num);
        while (!q2.isEmpty()) {
            Integer poll = q2.poll();
            q1.offer(poll);
        }
    }

    public Integer pop() {
        if (q1.isEmpty()) {
            return -1;
        }
        return q1.poll();
    }
}
