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
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start , b.start));


        for(int i = 0; i < intervals.size() -1 ; i++){
            Interval curr = intervals.get(i);
            Interval next = intervals.get(i + 1);

            int currEnd = curr.end;
            int nextStart = next.start;

            if(currEnd <= nextStart){
                continue;
            }

            if(currEnd > nextStart){
                return false;
            }
        }
        return true;
    }
}
