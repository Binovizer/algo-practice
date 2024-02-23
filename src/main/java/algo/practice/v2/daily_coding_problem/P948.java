package algo.practice.v2.daily_coding_problem;

/**
 * The type P948
 *
 * @author nadeem Date : 24/02/24
 */
public class P948 {
    public static void main(String[] args) {
        P948 p948 = new P948();
        p948.move(3, 1, 3, 2);
    }

    public void move(int n, int from, int to, int via) {
        if (n == 0) return;
        move(n - 1, from, via, to); // move n-1 disc from "from" to "via" using "to"
        System.out.println("Move disc " + n + " from " + from + " to " + to); // put this nth disc to "to"
        move(n - 1, via, to, from); // move n-1 disc from "via" to "to" using "from"
    }
}
