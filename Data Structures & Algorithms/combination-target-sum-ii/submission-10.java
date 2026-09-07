class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        Arrays.sort(candidates);
        findCombinations(candidates, target, 0, current, result);
        return result;
    }

      private void findCombinations(int[] arr, int target, int start, List<Integer> current, List<List<Integer>> result) {
            if(target == 0){
                        result.add(new ArrayList<>(current));
                        return;
            }

            for(int i = start; i < arr.length; i++){
                if(i > start && arr[i] == arr[i-1]){
                    continue;
                }
                    


              if(arr[i] <= target){
                current.add(arr[i]);
                findCombinations(arr, target - arr[i], i + 1, current, result);
                current.remove(current.size() - 1);
            }
            }
      }
}
