class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int ans = 0;
        int leftMax = 0;
        int rightMax = 0;

        while(left < right){
            if(height[left] < height[right]){
             leftMax = Math.max(leftMax, height[left]);
              ans += leftMax - height[left];
              left ++;
            } else{
               rightMax = Math.max(rightMax, height[right]);
              ans += rightMax - height[right];
              right --; 
            }
        }
        return ans;
    }
}
