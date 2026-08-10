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
        int n = intervals.size();
        int[] st = new int[n];
        int[] et = new int[n];

        for(int i = 0; i < n ; i++){
            st[i]= intervals.get(i).start;
            et[i] = intervals.get(i).end;
        }
        Arrays.sort(st);
        Arrays.sort(et);
        int count = 0;
        int i = 0;
        int j = 0;
        while(i < n){
            if(st[i] < et[j]){
                count++;
            } else{
                j++;
            }
            i++;
        }
        return count;
    }
}
