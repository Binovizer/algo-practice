package algo.practice.v2.oj.leetcode.contests.W_400;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * The type B
 *
 * @author nadeem Date : 11/06/24
 */
public class B {

    private static class Interval {
        int start;
        int end;

        @Override
        public String toString() {
            return "Interval{" + "start=" + start + ", end=" + end + '}';
        }

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        List<Interval> intervals = new ArrayList<>();
        for (int[] meeting : meetings) {
            intervals.add(new Interval(meeting[0], meeting[1]));
        }
        List<Interval> mergedIntervals = mergeInterval(intervals);
        // System.out.println(mergedIntervals);
        int ans = mergedIntervals.get(0).start - 1;
        for (int i = 1; i < mergedIntervals.size(); i++) {
            ans += mergedIntervals.get(i).start - mergedIntervals.get(i - 1).end - 1;
        }
        ans +=
                (days >= mergedIntervals.get(mergedIntervals.size() - 1).end)
                        ? days - mergedIntervals.get(mergedIntervals.size() - 1).end
                        : 0;
        return ans;
    }

    private List<Interval> mergeInterval(List<Interval> intervals) {
        if (intervals.size() <= 1) return intervals;
        List<Interval> ans = new ArrayList<>();
        Interval first = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval second = intervals.get(i);
            if (first.end >= second.start) {
                first.end = Math.max(first.end, second.end);
            } else {
                ans.add(first);
                first = second;
            }
        }
        ans.add(first);
        return ans;
    }
}
