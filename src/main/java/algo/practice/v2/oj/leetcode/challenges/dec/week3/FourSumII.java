package algo.practice.v2.oj.leetcode.challenges.dec.week3;

import java.util.HashMap;

/**
 * This is the description of what this type does
 *
 * @author Nadeem 2020-12-18
 */
public class FourSumII {

    public static void main(String[] args) {
        int[] A = {};
        int[] B = {};
        int[] C = {};
        int[] D = {};
        FourSumII fourSumII = new FourSumII();
        int count = fourSumII.fourSumCount(A, B, C, D);
        System.out.println("count = " + count);
    }

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        return fourSumCountOptimized(A, B, C, D);
    }

    public int fourSumCountBruteForce(int[] A, int[] B, int[] C, int[] D) {
        int sum = 0;
        for(int a : A){
            for(int b : B){
                for(int c : C){
                    for(int d : D){
                        if(a + b + c + d == 0){
                            sum += 1;
                        }
                    }
                }
            }
        }
        return sum;
    }

    // A + B = -(C + D)
    public int fourSumCountOptimized(int[] A, int[] B, int[] C, int[] D) {
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int a : A){
            for(int b : B){
                int ab = a + b;
                if(map.containsKey(ab)){
                    map.put(ab, map.get(ab) + 1);
                } else {
                    map.put(ab, 1);
                }
            }
        }
        for(int c : C){
            for(int d : D){
                int cd = c + d;
                int negativeCD = -1 * cd;
                if(map.containsKey(negativeCD)){
                    sum += map.get(negativeCD);
                }
            }

        }
        return sum;
    }
}
