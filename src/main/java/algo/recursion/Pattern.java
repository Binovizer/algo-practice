package algo.recursion;

/**
 * The type algo.recursion.Pattern
 *
 * @author Mohd Nadeem
 */
public class Pattern {

    public static void main(String[] args) {
        int n = 7;
        print(n);
    }

    private static void print(int n) {
        printUtil(0, n);
    }

    private static void printUtil(int row, int n) {
        if (row == n / 2) {
            printMiddleRow(row, n);
            return;
        }
        printRow(row, n);
        printUtil(row + 1, n);
        printRow(row, n);
    }

    private static void printMiddleRow(int row, int n) {
        for (int i = 0; i <= row; i++) {
            System.out.print("O ");
        }
        for (int i = 0; i < n; i++) {
            System.out.print("* ");
        }
        System.out.println();
    }

    private static void printRow(int row, int n) {
        for (int i = 0; i <= row; i++) {
            System.out.print("O ");
        }
        int underscores = n / 2 - row;
        for (int i = 0; i < underscores; i++) {
            System.out.print("- ");
        }
        System.out.print("* ");
        System.out.println();
    }
}
