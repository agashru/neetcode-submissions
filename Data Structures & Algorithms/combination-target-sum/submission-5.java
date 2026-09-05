class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        solve(nums, 0 , temp, target);
        return result;
    }

    public void solve(int[] nums, int start, List<Integer> temp, int target){
        if(target == 0){
            result.add(new ArrayList<>(temp));
            return;
        }
        if(target < 0){
            return;
        }

        for(int i = start; i < nums.length; i++){
                temp.add(nums[i]);
                solve(nums, i , temp , target - nums[i]);
                temp.remove(temp.size() - 1);
        }
    }
}
