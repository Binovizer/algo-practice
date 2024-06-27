package algo.practice.v2.oj.leetcode.contests.W_396;

/**
 * The type C
 *
 * @author nadeem Date : 11/05/24
 */
public class C {
    public static void main(String[] args) {
        C c = new C();
        int minLength = c.minAnagramLength("leetcodecodeleet");
        System.out.println("minLength = " + minLength);
    }

    public int minAnagramLength(String str) {
        int n = str.length();
        for (int k = 1; k <= n; k++) {
            if (n % k == 0) {
                String hash = generateHash(str.substring(0, k));
                int i;
                for (i = k; i < n; i += k) {
                    String nextHash = generateHash(str.substring(i, i + k));
                    if (!hash.equals(nextHash)) {
                        break;
                    }
                }
                if (i == n) return k;
            }
        }
        return n;
    }

    private String generateHash(String string) {
        StringBuilder sb = new StringBuilder();

        int[] charCount = new int[26];
        for (char c : string.toCharArray()) {
            charCount[c - 'a']++;
        }

        for (int j : charCount) {
            sb.append(j + '#');
        }
        return sb.toString();
    }
}
