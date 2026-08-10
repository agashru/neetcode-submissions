class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int i = 0;
        int j = 0;
        int[] res = new int[n - k + 1];
        int r = 0;
        ArrayDeque<Integer> pq = new ArrayDeque<>();

        while(i < n){
            while(!pq.isEmpty() && nums[i] > pq.peekLast()){
                pq.pollLast();
            }
            pq.add(nums[i]);

            if(i - j + 1 < k){
                i++;
            } else if(i - j + 1 == k){
                res[r++] = pq.peek();

                if(nums[j] == pq.peek()){
                    pq.poll();
                }
                i++;
                j++;
            }
        }
        return res;
    }
}
