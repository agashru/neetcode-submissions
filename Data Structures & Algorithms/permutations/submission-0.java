class Solution {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        solve(nums, temp);
        return result;
    }

    public void solve(int[] nums, List<Integer> temp){
        if(temp.size() == nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int n : nums){
            if(!temp.contains(n)){
                temp.add(n);
                solve(nums, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }

}
