class Solution {
    public int jump(int[] nums) {
        int maxReach = 0;
        int count = 0;
        int lastEnd = 0;


        for(int i = 0; i < nums.length - 1; i++){
            maxReach = Math.max(maxReach, i + nums[i]);

            if(i == lastEnd){
                lastEnd = maxReach;
                count++;
            }
        }
        return count;
    }
}
