class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer , Integer> mp = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>
        (new Comparator<Integer>() {
            @Override
            public int compare(Integer word1, Integer word2){
                int freq1 = mp.get(word1);
                int freq2 = mp.get(word2);
                if(freq1 == freq2) return word2.compareTo(word1);
                return freq1 - freq2;
            }
        });

        for(Map.Entry<Integer, Integer> entry : mp.entrySet()){
            pq.add(entry.getKey());
            if(pq.size() > k) pq.poll();
        }

        int[] result = new int[k];
        int i = 0;
        while(!pq.isEmpty()){
            result[i++] = pq.poll();
        }
        return result;
    }
}
