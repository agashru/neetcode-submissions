class Solution {
    public int search(int[] nums, int target) {
        int pivotIdx = findMin(nums);
        if(nums[pivotIdx] == target){
            return pivotIdx;
        }

        int idx = -1;
        idx = search(nums, 0, pivotIdx - 1, target);
        if(idx != -1){
            return idx;
        }
        return search(nums, pivotIdx + 1, nums.length - 1, target);
    }

    public int search(int[] nums, int si, int ei, int target) {
        int l = si; 
        int r = ei;

        while(l <= r){
            int mid = l + (r - l) /2;

            if(nums[mid] < target){
                l = mid + 1;
            } else if(nums[mid] > target){
                r = mid - 1;
            } else{
                return mid;
            }
        }
        return -1;
    }


    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;

        while( l < r){
            int mid = l + (r - l) /2;

            if(nums[mid] > nums[r]){
                l = mid + 1;
            } else{
                r= mid;
            }
        }
        return r;
    }
}
