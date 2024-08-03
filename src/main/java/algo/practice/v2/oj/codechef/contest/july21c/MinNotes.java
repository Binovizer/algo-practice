package algo.practice.v2.oj.codechef.contest.july21c;

import java.util.Arrays;
import java.util.Scanner;

public class MinNotes {

    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-- > 0) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            System.out.println(Arrays.toString(arr));
            // prefix[i] stores the gcd of all the elements before the index i from left
            int[] prefix = new int[n+1];
            prefix[0] = -1;
            prefix[1] = arr[0];
            for(int i = 2; i <= n; i++) {
                prefix[i] = gcd(arr[i-1], prefix[i-1]);
            }
            System.out.println(Arrays.toString(prefix));
            // suffix[i] stores the gcd of all the elements up to i(inclusive) from right
            int[] suffix = new int[n+1];
            suffix[n] = -1;
            suffix[n-1] = arr[n-1];
            for(int i = n-2; i >= 0; i--) {
                suffix[i] = gcd(arr[i], suffix[i+1]);
            }
            System.out.println(Arrays.toString(suffix));

            int maxGCD = prefix[n]; // the max with all the array elements
            int maxGCDIndex = -1;
            int maxNum = Integer.MIN_VALUE;
            int maxNumIndex = -1;
            for (int i = 0; i < n; i++) {
                int gcdWithoutCurr = gcd(prefix[i], suffix[i+1]);
                if(gcdWithoutCurr > maxGCD) {
                    maxGCD = gcdWithoutCurr;
                    maxGCDIndex = i;
                }
                if(arr[i] > maxNum) {
                    maxNum = arr[i];
                    maxNumIndex = i;
                }
            }
            System.out.println("maxGCD = " + maxGCD);
            System.out.println("maxGCDIndex = " + maxGCDIndex);
            System.out.println("maxNumIndex = " + maxNumIndex);
            System.out.println("maxNum = " + maxNum);
            if(maxGCDIndex == -1) {
                arr[maxNumIndex] = maxGCD;
            } else {
                arr[maxGCDIndex] = maxGCD;
            }
            int ans = 0;
            for(int i = 0; i < n; i++) {
                ans += (arr[i] / maxGCD);
            }
            System.out.println(ans);
        }
        in.close();
    }

    public static int gcd(int a, int b) {
        if(a == -1) {
            return b;
        }
        if(b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
