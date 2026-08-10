class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ngr = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i = n -1 ; i >= 0; i--){
            while(!st.isEmpty() && temperatures[i] >= temperatures[st.peek()]){
                st.pop();
            }

            if(st.isEmpty()){
                ngr[i] = 0;
            } else{
                ngr[i] = st.peek() - i;
            }
            st.push(i);
        }
        return ngr;
    }
}
