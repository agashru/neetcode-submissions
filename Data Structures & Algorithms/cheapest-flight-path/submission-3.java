class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> mp = new HashMap<>();

        int[] result = new int[n];
        Arrays.fill(result , Integer.MAX_VALUE);
        result[src] = 0;
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { src, 0});

        for(int[] flight : flights){
            int u = flight[0];
            int v = flight[1];
            int d = flight[2];

             mp.computeIfAbsent(u , x -> new ArrayList<>()).add(new int[] {v, d});
        }
        
       
        int level = 0;

        while(!q.isEmpty() && level <= k){
             int size = q.size();
            level ++;
             for(int i = 0 ; i < size; i++){
                int[] curr = q.poll();
                int u = curr[0];
                int d1 = curr[1];

                for(int[] nbr : mp.getOrDefault(u, new ArrayList<>())){
                    int v = nbr[0];
                    int d2 = nbr[1];
                    if(d1 + d2 < result[v]){
                        result[v] = d1 + d2;
                        q.add(new int[] { v , d1 + d2});
                    }
                }
             }
        }
        return result[dst] == Integer.MAX_VALUE ? -1 : result[dst];
    }
    
}
