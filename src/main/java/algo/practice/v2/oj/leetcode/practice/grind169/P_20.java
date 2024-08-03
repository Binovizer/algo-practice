package algo.practice.v2.oj.leetcode.practice.grind169;

import java.util.Stack;

/**
 * The type P_20
 *
 * @author nadeem Date : 26/07/24
 */
public class P_20 {

    public static void main(String[] args) {}

    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                st.push(c);
            } else {
                if (st.empty()) return false;
                char pop = st.pop();
                if (c == ']' && pop != '[') return false;
                if (c == '}' && pop != '{') return false;
                if (c == ')' && pop != '(') return false;
            }
            i++;
        }
        return st.empty();
    }
}
