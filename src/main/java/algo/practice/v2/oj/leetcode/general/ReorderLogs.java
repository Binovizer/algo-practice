package algo.practice.v2.oj.leetcode.general;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/reorder-data-in-log-files/
 *
 * @author Nadeem 2021-02-27
 */
public class ReorderLogs {

    public String[] reorderLogFiles(String[] logs) {
        List<String> lets = new ArrayList<>();
        List<String> digits = new ArrayList<>();
        for (String str : logs) {
            int i;
            for (i = 0; i < str.length(); i++) {
                if (str.charAt(i) == ' ') {
                    break;
                }
            }
            boolean haveDigit = false;
            for (int j = i + 1; j < str.length(); j++) {
                if (Character.isDigit(str.charAt(j))) {
                    haveDigit = true;
                    break;
                }
            }
            if (haveDigit) {
                digits.add(str);
            } else {
                lets.add(str);
            }
        }
        lets.sort(
                (s1, s2) -> {
                    int i;
                    for (i = 0; i < s1.length(); i++) {
                        if (s1.charAt(i) == ' ') {
                            break;
                        }
                    }
                    String key1 = s1.substring(0, i);
                    String log1 = s1.substring(i + 1);
                    int j;
                    for (j = 0; j < s2.length(); j++) {
                        if (s2.charAt(j) == ' ') {
                            break;
                        }
                    }
                    String key2 = s1.substring(0, j);
                    String log2 = s2.substring(j + 1);
                    if (log1.compareTo(log2) == 0) {
                        return key2.compareTo(key1);
                    }
                    return log1.compareTo(log2);
                });
        String[] ans = new String[logs.length];
        int index = 0;
        for (String let : lets) {
            ans[index++] = let;
        }
        for (String dig : digits) {
            ans[index++] = dig;
        }
        return ans;
    }
}
