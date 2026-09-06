class Solution {
    public int search(int[] nums, int target) {
        int pivotIndex = findMinimum(nums);
        if(nums[pivotIndex] == target){
            return pivotIndex;   
        }

        int idx = -1;
        idx = findTarget(nums, 0 , pivotIndex - 1, target);
        if(idx != -1){
            return idx;
        }
        return findTarget(nums, pivotIndex + 1, nums.length - 1, target);
    }

    public int findMinimum(int[] nums){
        int l = 0;
        int r = nums.length - 1;

        while(l < r){
            int m = l + (r - l) / 2;
            if(nums[m] > nums[r]){
                l = m + 1;
            }else{
                r = m ;
            }
        }
        return r;
    }

    public int findTarget(int[] nums, int l , int r , int target){

        while(l <= r){
            int m = l + (r - l) / 2;
            if(nums[m] < target){
                l = m + 1;
            }else if (nums[m] > target){
                 r = m - 1;
            }else{
                return m;
            }
        }
        return -1;
    }
}
