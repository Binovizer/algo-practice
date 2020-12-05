package algo.interview.recursion.tube;

import java.util.ArrayList;
import java.util.List;

/**
 * This class helps solve the josephus problem
 *
 * @author Nadeem 2020-11-22
 */
public class JosephusProblem {

    public static void main(String[] args) {
        int n = 40;
        int k = 7;
        JosephusProblem josephusProblem = new JosephusProblem();
        int safePosition = josephusProblem.solve(n, k);
        System.out.println("safePosition = " + safePosition);
    }

    /**
     * Solves the josephus problem
     *
     * @param n the n
     * @param k the k
     * @return the safe position
     */
    private int solve(int n, int k) {
        List<Integer> circle = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            circle.add(i);
        }
        solve(circle, 0, k - 1);
        return circle.get(0);
    }

    /**
     * Solves the josephus problem
     *
     * @param circle the circle
     * @param index the index where person has to die
     * @param k the counting
     */
    private void solve(List<Integer> circle, int index, int k) {
        if (circle.size() == 1) {
            return;
        }
        index = (index + k) % circle.size();
        circle.remove(index);
        solve(circle, index, k);
    }
}
