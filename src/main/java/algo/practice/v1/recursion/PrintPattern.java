package algo.practice.v1.recursion;

/**
 * The type PrintPattern
 *
 * @author Mohd Nadeem
 */
public class PrintPattern {

    public static void main(String[] args) {
        printPattern(10);
    }

    private static void printPattern(int num) {
        if (num <= 0) {
            System.out.print(num + " ");
            return;
        }
        System.out.print(num + " ");
        printPattern(num - 5);
        System.out.print(num + " ");
    }
}
