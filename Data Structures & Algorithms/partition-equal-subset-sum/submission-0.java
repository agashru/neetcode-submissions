class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int n : nums){
            sum += n;
        }

        if(sum % 2 != 0){
            return false;
        }

        return solve(nums, sum/2);
    }

    public boolean solve(int[] nums, int sum){
        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];

        for(int j = 0 ; j < dp[0].length; j++){
            dp[0][j] = false;
        }

        for(int i = 0; i < dp.length; i++){
            dp[i][0] = true;
        }


        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(nums[i-1] <= j){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j - nums[i-1]];
                } else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }
}
