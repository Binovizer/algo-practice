package stack;

/**
 * The type StackUsingTwoQueues
 *
 * @author Mohd Nadeem
 */
public class StackUsingTwoQueues {

    public static void main(String[] args) {
        StackUsingQueues stackUsingQueues = new StackUsingQueues();
        stackUsingQueues.push(1);
        stackUsingQueues.push(2);
        stackUsingQueues.push(3);
        Integer pop = stackUsingQueues.pop();
        System.out.println("pop1 = " + pop);
        stackUsingQueues.push(4);
        stackUsingQueues.push(5);
        System.out.println("pop2 = " + stackUsingQueues.pop());
        System.out.println("pop2 = " + stackUsingQueues.pop());
        System.out.println("pop2 = " + stackUsingQueues.pop());
        System.out.println("pop2 = " + stackUsingQueues.pop());

    }


}
