package algo.practice.v2.paradigms.recursion.tube;

/**
 * This is the description of what this type does
 *
 * @author Nadeem 2020-11-21
 */
public class TowerOfHanoi {

    public static final String OUTPUT_FORMAT = "Move disk %s from tower %s to tower %s";

    public static void main(String[] args) {
        int n = 3;
        TowerOfHanoi towerOfHanoi = new TowerOfHanoi();
        towerOfHanoi.solve(n, 'A', 'C', 'B');
    }

    /**
     * Solves the tower of hanoi problem
     *
     * @param noOfDisks the no of disks
     * @param source the source
     * @param dest the destination
     * @param helper the helper
     */
    private void solve(int noOfDisks, char source, char dest, char helper) {
        if (noOfDisks == 1) {
            System.out.println(String.format(OUTPUT_FORMAT, noOfDisks, source, dest));
            return;
        }
        solve(noOfDisks - 1, source, helper, dest);
        System.out.println(String.format(OUTPUT_FORMAT, noOfDisks, source, dest));
        solve(noOfDisks - 1, helper, dest, source);
    }
}
