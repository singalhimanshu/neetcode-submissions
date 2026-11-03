/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        List<int[]> list = new ArrayList<>();
        for (Interval interval: intervals) {
            list.add(new int[]{interval.start, 1});
            list.add(new int[]{interval.end, -1});
        }
        Collections.sort(list, (v1, v2) -> Integer.compare(v1[0], v2[0]));
        int count = 0;
        for (int[] val: list) {
            count += val[1];
            if (count > 1) return false;
        }
        return true;
    }
}
