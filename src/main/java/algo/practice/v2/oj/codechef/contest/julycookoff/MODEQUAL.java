package algo.practice.v2.oj.codechef.contest.julycookoff;

import java.util.Arrays;
import java.util.Scanner;

/**
 * The type MODEQUAL
 *
 * @author nadeem Date : 28/07/21
 */
public class MODEQUAL {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            Arrays.sort(arr);
            int count = 1;
            int pre = arr[0];
            for (int i = 0; i < n; i++) {
                if (arr[i] == arr[i + 1]) {
                    count++;
                } else {
                    break;
                }
            }
            boolean flag = true;
            for (int i = count; i < n; i++) {
                if (arr[i] % (arr[i] - pre) != pre) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println(n - count);
            } else {
                System.out.println(n);
            }
        }
    }
}
