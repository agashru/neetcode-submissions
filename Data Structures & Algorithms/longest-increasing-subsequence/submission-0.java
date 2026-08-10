class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int oMax = 0;

        for(int i = 0; i < n; i++){
            int length = 0;
            for(int j = 0 ; j < i ; j++){
                if(nums[j] < nums[i]){
                    if(dp[j] > length){
                        length = dp[j];
                    }
                }
            }
            dp[i] = length + 1;
            oMax = Math.max(dp[i], oMax);
        }
        return oMax;
    }
}
