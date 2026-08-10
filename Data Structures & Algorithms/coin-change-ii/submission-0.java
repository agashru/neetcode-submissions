class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];

        dp[0] = 1;

        for(int c : coins){
            for(int target = 1; target < dp.length ; target++){
                if(c <= target){
                    dp[target] = dp[target] + dp[target - c];
                }
            }
        }
        return dp[amount];
    }
}
