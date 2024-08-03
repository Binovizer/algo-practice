package algo.practice.v2.oj.codechef.contest.july21c;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Chefora {

    private static List<Integer> list;
    private static int MOD = 1000000000 + 7;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        list = new ArrayList<>();
        preparePalindromeList(10);
        System.out.println("list size = " + list.size());
        int t = in.nextInt();
        while (t-- > 0) {
            int l = in.nextInt(); //exclusive
            int r = in.nextInt(); //inclusive
            long ans = 1;
            int Al = list.get(l-1);
            for (int i = l+1; i <= r; i++) {
                int Ai = list.get(i-1);
//                System.out.println("Al = " + Al);
//                System.out.println("Ai = " + Ai);
                long pow = pow(Al, Ai);
//                System.out.println("pow = " + pow);
                ans = (ans * pow) % MOD;
            }
            System.out.println(ans);
        }
        in.close();
    }

    private static long pow(int a, int b) {
        long res = a;
        while (b-- > 1) {
            res = (res * a) % MOD;
        }
        return res;
    }

    private static void preparePalindromeList(int digits) {
        if(digits % 2 == 0) digits--;
        for (int i = 1; i <= 9; i++) {
            list.add(i);
        }
        int half = digits / 2;
        int d = 0;
        int num = 0;
        while(d < half) {
            num = num * 10 + 9;
            d++;
        }
        for(int i = 1; i <= num; i++) {
            for (int j = 0; j < 10; j++) {
                StringBuilder sb = new StringBuilder();
                sb.append(i);
                StringBuilder reverse = new StringBuilder(sb.toString()).reverse();
                sb.append(j);
                sb.append(reverse);
                list.add(Integer.parseInt(sb.toString()));
            }
        }
    }
}
