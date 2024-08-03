package algo.practice.v2.oj.leetcode.challenges.dec.week3;

import algo.practice.v2.utils.StringUtil;

/**
 * This is the description of what this type does
 *
 * @author Nadeem 2020-12-20
 */
public class DecodedStringAtIndex {

    public static void main(String[] args) {
        String S = "leet2code3";
        int K = 19;
        DecodedStringAtIndex decodedStringAtIndex = new DecodedStringAtIndex();
        String charAtIndex = decodedStringAtIndex.decodeAtIndex(S, K);
        System.out.println("charAtIndex = " + charAtIndex);
    }

    public String decodeAtIndex(String S, int K) {
        return decodeAtIndexOptimized(S, K);
    }

    private String decodeAtIndex(String S, int curr, String out) {
        if (S.equals("")) {
            return out;
        }
        int i;
        int times = 1;
        int n = S.length();
        StringBuilder str = new StringBuilder(out);
        for (i = 0; i < n; i++) {
            if (Character.isDigit(S.charAt(i))) {
                times = Integer.parseInt(S.charAt(i) + "");
                break;
            } else {
                str.append(S.charAt(i));
            }
        }
        String completeString = StringUtil.repeatString(str.toString(), times);
        if (i == n) {
            return completeString;
        }
        return decodeAtIndex(S.substring(i + 1), i + 1, completeString);
    }

    private String decodeAtIndexOptimized(String S, int K) {
        int n = S.length();
        long size = 0;
        for (int i = 0; i < n; i++) {
            char c = S.charAt(i);
            if (Character.isDigit(c)) {
                size *= c - '0';
            } else {
                size++;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            K %= size;
            char c = S.charAt(i);
            if (K == 0 && Character.isLetter(c)) {
                return String.valueOf(c);
            }
            if (Character.isDigit(c)) {
                size /= c - '0';
            } else {
                size--;
            }
        }
        return "";
    }
}
