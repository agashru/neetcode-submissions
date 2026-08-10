class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int n = queries.length;
        int[][] queryIndex = new int[n][2];
        for(int i = 0; i < n ; i++){
            queryIndex[i] = new int[] {queries[i], i};
        }
        Arrays.sort(queryIndex , (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(intervals,  (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> Integer.compare(a[1] - a[0], b[1] - b[0])
        );
        int[] result = new int[n];
        int j = 0;
        
        for(int[] q : queryIndex){
            int query = q[0];
            int idx = q[1];

            while(j < intervals.length && intervals[j][0] <= query){
                pq.add(intervals[j]);
                j++;
            }

            while(!pq.isEmpty() && pq.peek()[1] < query){
                pq.poll();
            }
            result[idx] = pq.isEmpty() ? -1 : pq.peek()[1] - pq.peek()[0] + 1;
        }
        return result;
    }
}
