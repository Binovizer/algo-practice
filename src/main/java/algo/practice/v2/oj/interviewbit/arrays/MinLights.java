package algo.practice.v2.oj.interviewbit.arrays;

/**
 * This is the description of what this type does
 *
 * @author Nadeem 2020-12-18
 */
public class MinLights {

    public static void main(String[] args) {
        int[] A = {0, 0, 1, 1, 1, 0, 0};
        int B = 1;
        MinLights minLights = new MinLights();
        int solve = minLights.solve(A, B);
        System.out.println("solve = " + solve);
    }

    public int solve(int[] A, int B) {
        return solve(A, B, 0, A.length);
    }

    // Not Working
    private int solve(int[] A, int B, int curr, int n) {
        if (curr + B >= n) {
            return 0;
        }
        int start = Math.max(curr - B + 1, 0);
        int end = Math.min(curr + B - 1, n - 1);
        int nextCurr = curr;
        while (end >= start) {
            if (A[end] == 1) {
                nextCurr = end;
                break;
            }
            end--;
        }
        return 1 + solve(A, B, nextCurr, n);
    }
}
