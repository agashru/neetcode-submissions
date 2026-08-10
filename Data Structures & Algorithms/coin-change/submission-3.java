class Solution {
    public int coinChange(int[] coins, int amount) {
        int  n = coins.length;
        int[] dp = new int[amount+1];
        

        for(int target = 1; target <= amount; target++){
            dp[target] = Integer.MAX_VALUE;
            for(int coin : coins){
                if(coin <= target && dp[target - coin] != Integer.MAX_VALUE){
                    dp[target] = Math.min(dp[target], 1 + dp[target - coin]);
                }
            }
        }

        if(dp[amount] == Integer.MAX_VALUE){
            return -1;
        }
        return dp[amount];
    }
}
