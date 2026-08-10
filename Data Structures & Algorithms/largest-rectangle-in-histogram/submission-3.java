class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] nsl = new int[n];
        int[] nsr = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < n ; i++){
            while(!st.isEmpty() && heights[i] <= heights[st.peek()]){
                st.pop();
            }

            if(st.isEmpty()){
                nsl[i] = -1;
            } else{
                nsl[i] = st.peek();
            }
            st.push(i);
        }

        st = new Stack<>();
        for(int i = n-1; i >= 0 ; i--){
            while(!st.isEmpty() && heights[i] <= heights[st.peek()]){
                st.pop();
            }

            if(st.isEmpty()){
                nsr[i] = n;
            } else{
                nsr[i] = st.peek();
            }
            st.push(i);
        }

        int max = 0;
        for(int i = 0; i < n ; i++){
            int width = nsr[i] - nsl[i] - 1;
            int area = width * heights[i];
            max = Math.max(max, area);
        }
        return max;


    }
}
