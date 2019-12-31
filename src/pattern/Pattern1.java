package pattern;

/**
 * The type Pattern1
 *
 * @author Mohd Nadeem
 */
public class Pattern1 {

    public static void main(String[] args) {
        Pattern1 pattern1 = new Pattern1();
        pattern1.printPattern(4);
    }

    public void printPattern(int n) {
        int k = 1;
        for (int i = 1; i <= n; i++) {
            for (int s = n; s > i; s--) {
                System.out.print("\t");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.format("%2d\t", k);
                k++;
            }
            System.out.println();
        }
        for (int i = n - 1; i >= 1; i--) {
            for (int s = n; s > i; s--) {
                System.out.print("\t");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.format("%2d\t", k);
                k++;
            }
            System.out.println();
        }
    }
}
