class Solution {
    public int subarraySum(int[] nums, int k) {
        int cSum = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        int count = 0;

        for(int n : nums){
            cSum += n;

            if(mp.containsKey(cSum - k)){
                count += mp.get(cSum - k);
            }
            mp.put(cSum , mp.getOrDefault(cSum, 0) + 1);
        }
        return count;
    }
}