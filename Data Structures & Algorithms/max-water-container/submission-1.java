class Solution {
    public int maxArea(int[] heights) {
        int maxArea = 0;
        int n = heights.length;
        int i = 0;
        int j = n - 1;
        
        while(i < j){
            int area = Math.min(heights[i], heights[j]) * (j - i);
            maxArea = Math.max(area, maxArea);

            if(heights[i] < heights[j]){
                i++;
            } else{
                j--;
            }
        }
        return maxArea;
    }
}
