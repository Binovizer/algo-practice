package algo.practice.v2.oj.leetcode.contests.W_405;

import java.util.ArrayList;
import java.util.List;

/**
 * The type B
 *
 * @author nadeem Date : 08/07/24
 */
public class B {

    public static void main(String[] args) {
        B b = new B();
        List<String> strings = b.validStrings(1);
        System.out.println("strings = " + strings);
    }

    private List<String> ans;

    public List<String> validStrings(int n) {
        ans = new ArrayList<>();
        recursion(n, "", true);
        return ans;
    }

    private void recursion(int n, String currentString, boolean canTakeZero) {
        if (n == 0) {
            ans.add(currentString);
            return;
        }
        if (canTakeZero) {
            recursion(n - 1, "0" + currentString, false);
            recursion(n - 1, "1" + currentString, true);
        } else {
            recursion(n - 1, "1" + currentString, true);
        }
    }
}
