package algo.practice.v2.oj.leetcode.challenges.may.week1;

public class FirstBadVersion {

    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    /**
     * Dummy Implementation
     *
     * @param mid the element to be checked
     * @return returns if it is a bad version
     */
    private boolean isBadVersion(int mid) {
        return true;
    }

    public static void main(String[] args) {}
}
