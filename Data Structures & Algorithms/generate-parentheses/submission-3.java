class Solution {
    public List<String> generateParenthesis(int n) {
        List<String>[] dp = new List[n+1];
        dp[0] = Arrays.asList("");
        dp[1] = Arrays.asList("()");

        for(int i = 2; i <= n ; i++){
            dp[i] = new ArrayList<>();
            int outer = i - 1;
            int inner = 0;

            while(outer >= 0 && inner <= i-1){
                for(String out : dp[outer]){
                    for(String in : dp[inner]){
                        StringBuilder sb = new StringBuilder();
                        sb.append("(");
                        sb.append(out);
                        sb.append(")");
                        sb.append(in);
                        dp[i].add(sb.toString());
                    }
                }
                outer --;
                inner ++;
            }
        }
        return dp[n];
    }
}
