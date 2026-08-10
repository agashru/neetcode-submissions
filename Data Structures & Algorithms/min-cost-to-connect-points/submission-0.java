class Solution {
    public int minCostConnectPoints(int[][] points) {
        Map<Integer, List<int[]>> mp = new HashMap<>();

        int n = points.length;

        for(int i = 0 ; i < n - 1; i++){
            for(int j = i + 1; j < n ; j++){
                int x1 = points[i][0];
                int y1 = points[i][1];

                int x2 = points[j][0];
                int y2 = points[j][1];

                int d = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                mp.computeIfAbsent(i ,x ->  new ArrayList<>()).add(new int[] { j , d});
                mp.computeIfAbsent(j ,x ->  new ArrayList<>()).add(new int[] { i , d});
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> Integer.compare(a[1], b[1])
        );
        pq.add(new int[] {0, 0});
        boolean[] inMst = new boolean[n];
        int sum = 0;

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int u = curr[0];
            int d1 = curr[1];


            if(inMst[u]){
                continue;
            }
            inMst[u] = true;
            sum += d1;

            for(int[] neighbor : mp.getOrDefault(u , new ArrayList<>())){
                int v = neighbor[0];
                int d2 = neighbor[1];

                if(!inMst[v]){
                    pq.add(new int[] {v , d2});
                }
            }
        }
        return sum;
    }
}
