class Solution {
     List <List<Integer>> ans = new ArrayList <>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> ds = new ArrayList<>();
        Arrays.sort(candidates);
        findCombinations(candidates, target,0, ds);
        return ans;
    }

     private void findCombinations(int[] arr, int target, int start, List<Integer> current) {
        if (target == 0) {
            ans.add(new ArrayList<>(current));
            return;
        }
        
        for (int i = start; i < arr.length; i++) {
            if (i > start && arr[i] == arr[i - 1]) {
                continue; // Ignore duplicate elements
            }

            if (arr[i] <= target) { // Only proceed if we can subtract
                current.add(arr[i]);
                findCombinations(arr, target - arr[i], i + 1, current); // i allows reuse
                current.remove(current.size() - 1);
            }
        }
    }
}
