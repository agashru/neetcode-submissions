class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[1], b[1])
        );

        for(int n : nums){
            mp.put(n , mp.getOrDefault(n , 0) + 1);
        }

        for(Map.Entry<Integer, Integer> e : mp.entrySet()){
            int key = e.getKey();
            int value = e.getValue();
            pq.add(new int[] {key , value});

            if(pq.size() > k){
                pq.poll();
            }
        }
        int i = 0;
        int[] result = new int[k];
        while(pq.size() > 0){
            result[i++] = pq.poll()[0];
        }
        return result;
    }
}
