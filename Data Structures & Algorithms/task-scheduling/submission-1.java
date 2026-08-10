class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];

        for(char ch : tasks){
            freq[ch - 'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int f : freq){
            if(f > 0){
                pq.add(f);
            }
        }

        int sum = 0;
        while(!pq.isEmpty()){
            List<Integer> result = new ArrayList<>();
            for(int i = 0; i <= n ; i++){
                if(!pq.isEmpty()){
                    int freq1 = pq.poll();
                    freq1--;
                    result.add(freq1);
                }
            }

            for(int r : result){
                if(r > 0){
                    pq.add(r);
                }
            }

            if(pq.isEmpty()){
                sum += result.size();
            }else {
                sum += n + 1;
            }           
        }
        return sum;
    }
}
