class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];

        for(int g = 0; g < dp.length; g++){
            for(int i = 0, j = g; j < dp.length ; i++, j++){
                int max = Integer.MIN_VALUE;
                for(int k = i ; k <= j ; k++){
                    int l = (k == i) ? 0 : dp[i][k-1];
                    int r = (k == j) ? 0 : dp[k+1][j];

                    int val = (i == 0 ? 1 : nums[i-1]) * nums[k] 
                    * (j == n -1 ? 1 : nums[j+1]);

                    int total = l + r + val;
                    max = Math.max(total, max);
                }
                dp[i][j] = max;
            }
        }
        return dp[0][n-1];
    }
}
