class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        HashSet<Integer> seen = new HashSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length ; i ++){
            if(!seen.contains(nums[i])){
                for(int j = i +1; j < nums.length; j++){
                    int complement = -nums[i] - nums[j];
                    if(map.containsKey(complement) && map.get(complement) == i){
                        List<Integer> list = Arrays.asList(nums[i], nums[j], complement);
                        Collections.sort(list);
                        result.add(list);
                    }
                    map.put(nums[j], i);
                }
            }
        }

        return new ArrayList(result);
    }
}
