package stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * The type StackUsingQueues
 *
 * @author Mohd Nadeem
 */
public class StackUsingQueues {

    private final Queue<Integer> q1;
    private final Queue<Integer> q2;

    public StackUsingQueues() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(Integer num) {
        while(!q1.isEmpty()){
            Integer poll = q1.poll();
            q2.offer(poll);
        }
        q1.offer(num);
        while(!q2.isEmpty()){
            Integer poll = q2.poll();
            q1.offer(poll);
        }
    }

    public Integer pop() {
        if(q1.isEmpty()){
            return -1;
        }
        return q1.poll();
    }
}
