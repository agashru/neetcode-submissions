class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);


        for(int n : nums){
            Map<Integer, Integer> newMp = new HashMap<>();
            for(int sum : mp.keySet()){
                int count = mp.get(sum);
                newMp.put(sum + n , newMp.getOrDefault(sum + n, 0) + count);
                newMp.put(sum - n , newMp.getOrDefault(sum - n, 0) + count);
            }
            mp = newMp;
        }
        return mp.getOrDefault(target, 0);
    }
}
