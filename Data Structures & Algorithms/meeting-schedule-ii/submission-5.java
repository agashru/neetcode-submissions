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
    public int minMeetingRooms(List<Interval> intervals) {
  TreeMap<Integer, Integer> mp = new TreeMap<>();
       for(Interval d : intervals){
        mp.merge(d.start, 1, Integer::sum);
        mp.merge(d.end, -1, Integer::sum);
       }

       int current = 0;
       int max= 0;
       for(int c : mp.values()){
        current += c;
        max = Math.max(current, max);
       }
       return max;
    }
}
