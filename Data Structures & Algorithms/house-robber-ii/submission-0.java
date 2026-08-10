class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0){
            return 0;
        }

        if(n == 1){
            return nums[0];
        }

        int skipFirst = solve(nums, 1, n-1);
        int skipLast = solve(nums, 0, n - 2);
        return Math.max(skipFirst, skipLast);
    }


    public int solve(int[] nums, int s, int e){
        int inc = nums[s];
        int exc = 0;

        for(int i = s + 1; i <= e; i++){
            int ninc = exc + nums[i];
            int nexc = Math.max(inc, exc);

            inc = ninc;
            exc = nexc;
        }
        return Math.max(inc, exc);
    }
}
