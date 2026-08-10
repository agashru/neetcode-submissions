class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> mp = new HashMap<>();
        int[] result = new int[n+1];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[k] = 0;

        for(int[] time : times){
            int u = time[0];
            int v = time[1];
            int t = time[2];
            mp.computeIfAbsent(u , x -> new ArrayList<>()).add(new int[] {v , t});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> Integer.compare(a[1], b[1])
        );

        pq.add(new int[] {k, 0});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int u = curr[0];
            int t1 = curr[1];

            for(int[] neighbor: mp.getOrDefault(u , new ArrayList<>())){
                int v = neighbor[0];
                int t2 = neighbor[1];

                if(t1 + t2 < result[v]){
                    result[v] = t1 + t2;
                    pq.add(new int[] {v , t1 + t2});
                }
            }
        }

        int sum = Integer.MIN_VALUE;
        for(int i = 1 ; i <= n ; i++){
            sum = Math.max(sum , result[i]);
        }
        return sum == Integer.MAX_VALUE ? -1 : sum;
    }
}
