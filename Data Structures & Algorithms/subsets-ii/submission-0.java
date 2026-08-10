class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);
        solve(nums, 0 , temp);
        return result;
    }

    public void solve(int[] nums, int start , List<Integer> temp){
       result.add(new ArrayList<>(temp)); // Add current subset
        
        for(int i = start; i < nums.length; i++){
            // Skip duplicates at same level
            if (i > start && nums[i] == nums[i - 1]) {
            continue;
            }

            temp.add(nums[i]);
            solve(nums, i + 1, temp); // Use i + 1, not start + 1
            temp.remove(temp.size() - 1);
        }
    }
}
