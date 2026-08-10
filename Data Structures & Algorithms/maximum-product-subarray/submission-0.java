class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int lp = 1;
        int rp = 1;
        int result = nums[0];

        for(int i = 0; i < n ; i++){
            lp = (lp == 0 || lp < Integer.MIN_VALUE) ? 1 : lp;
            rp = (rp == 0 || rp < Integer.MIN_VALUE) ? 1 : rp;

            lp = lp * nums[i];
            rp = rp * nums[n - 1 - i];
            result = Math.max(result, Math.max(lp, rp));
        }
        return result;
    }
}
