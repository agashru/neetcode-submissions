class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0,1);

        for(int n : nums){
            Map<Integer, Integer> temp = new HashMap<>();

            for(int sum : mp.keySet()){
                int count = mp.get(sum);

                temp.put(sum + n , temp.getOrDefault(sum + n, 0) + count);
                temp.put(sum - n , temp.getOrDefault(sum - n, 0) + count);
            }
            mp = temp;
        }
        return mp.getOrDefault(target, 0);
    }
}
