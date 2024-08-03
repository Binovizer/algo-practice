package algo.practice.v2.oj.leetcode.contests.W_405;

/**
 * The type A
 *
 * @author nadeem Date : 08/07/24
 */
public class A {

    public static void main(String[] args) {
        A a = new A();
        String encryptedString = a.getEncryptedString("dart", 3);
        System.out.println("encryptedString = " + encryptedString);
    }

    public String getEncryptedString(String s, int k) {
        int n = s.length();
        k = k % n;
        if (k == 0) return s;

        int start = k;
        StringBuilder sb = new StringBuilder();
        while (start < n) {
            sb.append(s.charAt(start));
            start++;
        }
        int i = 0;
        while (i < k) {
            sb.append(s.charAt(i));
            i++;
        }
        return sb.toString();
    }
}
