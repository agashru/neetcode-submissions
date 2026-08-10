class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();

        for(int n : nums){
            mp.put(n, mp.getOrDefault(n , 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> Integer.compare(a[1], b[1])
        );

        for(Map.Entry<Integer, Integer> m : mp.entrySet()){
            int key = m.getKey();
            int value = m.getValue();

            pq.add(new int[] {key, value});

            while(pq.size()> k){
                pq.poll();
            }
        }

        int[] res = new int[k];
        int i = 0;

        while(pq.size() > 0){
            res[i] = pq.poll()[0];
            i++;
        }
        return res;
    }
}
