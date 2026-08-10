class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }
        if (k > nums.length) {
            k = nums.length;
        }
        
        int n = nums.length;
        int[] result = new int[n - k + 1];
        ArrayDeque<Integer> deque = new ArrayDeque<>(); // Stores indices, not values
        
        for (int i = 0; i < n; i++) {
            // Remove indices that are outside the current window [i-k+1, i]
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }
            
            // Maintain decreasing order: remove smaller elements from back
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            
            // Add current index
            deque.addLast(i);
            
            // The front of deque is the maximum for current window
            // Start recording results once we have a full window
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        
        return result;
    }
}
