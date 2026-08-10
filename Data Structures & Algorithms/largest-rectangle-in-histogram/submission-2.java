class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] nsl = new int[n];
        int[] nsr = new int[n];
        Stack<Integer> st = new Stack<>();

        int pseudoIndex = -1;
        for(int i = 0; i < n ; i++){
            while(!st.isEmpty() && heights[i] <= heights[st.peek()]){
                st.pop();
            }

            if(st.isEmpty()){
                nsl[i] = pseudoIndex;
            } else{
                nsl[i] = st.peek();
            }
            st.push(i);
        }

        st = new Stack<>();
        pseudoIndex = n;
        for(int i = n-1; i >=0 ; i--){
            while(!st.isEmpty() && heights[i] <= heights[st.peek()]){
                st.pop();
            }

            if(st.isEmpty()){
                nsr[i] = pseudoIndex;
            } else{
                nsr[i] = st.peek();
            }
            st.push(i);
        }

        int maxArea = 0;
        for(int i = 0; i < n ; i++){
                int width = nsr[i] - nsl[i] -1;
                int area = width * heights[i];
                maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}
