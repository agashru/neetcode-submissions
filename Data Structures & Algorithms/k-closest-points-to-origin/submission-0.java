class Solution {
    public int squared(int[] a){
        return a[0] * a[0] + a[1] * a[1];
    }
    
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> squared(b) - squared(a)
        );

        for(int[] p : points){
            pq.add(p);

            if(pq.size() > k){
                pq.poll();
            }
        }

        int[][] result = new int[k][2];
        int i = 0;

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            result[i][0] = curr[0];
            result[i][1] = curr[1];
            i++;
        }
        return result;
    }
}
