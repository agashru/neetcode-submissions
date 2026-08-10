class Solution {
    public int maxSubArray(int[] nums) {
        int cSum = nums[0];
        int oSum = nums[0];
        for(int i =1; i < nums.length; i++){
            if(cSum < 0){
                cSum = nums[i];
            } else{
                cSum += nums[i];
            }
            oSum = Math.max(oSum, cSum);
        }
        return oSum;
    }
}
