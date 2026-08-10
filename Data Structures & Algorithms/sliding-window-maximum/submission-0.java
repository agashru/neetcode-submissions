class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] output = new int[n - k +1];
        Deque<Integer> q = new ArrayDeque<>();
        int l = 0 , r = 0;

        while(r < n){
            //pop smaller values from q
            while(!q.isEmpty() && nums[q.peekLast()] < nums[r]){
                q.pollLast();
            }
            q.offer(r);

           //remove left val from window
            if(l > q.peekFirst()){
                q.pollFirst();
            }

            if(r + 1 >= k){
                output[l] = nums[q.peekFirst()];
                l++;
            }
            r++;
        }
        return output;
    }
}
