class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> mp = new HashSet<>();

        for(int n : nums){
            if(mp.contains(n)){
                return true;
            }
            mp.add(n);
        }
        return false;
    }
}