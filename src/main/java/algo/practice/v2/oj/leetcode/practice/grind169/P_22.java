package algo.practice.v2.oj.leetcode.practice.grind169;

import java.util.ArrayList;
import java.util.List;

/**
 * The type P_22
 *
 * @author nadeem Date : 26/07/24
 */
public class P_22 {

    public static void main(String[] args) {
        P_22 p22 = new P_22();
        List<String> generated = p22.generateParenthesis(3);
        System.out.println("generated = " + generated);
    }

    private List<String> ans;

    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        if (n == 0) return ans;

        generate(0, 0, "", n);
        return ans;
    }

    private void generate(int open, int closed, String current, int n) {
        if (open == n && closed == n) {
            ans.add(current);
            return;
        }
        // add open bracket
        if (open < n) generate(open + 1, closed, current + '(', n);

        // add closed bracket
        if (open > closed) {
            generate(open, closed + 1, current + ')', n);
        }
    }
}
