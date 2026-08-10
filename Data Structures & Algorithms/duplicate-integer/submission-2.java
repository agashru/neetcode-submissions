class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> st = new HashSet<>();
        for(int n : nums){
            if(st.contains(n)){
                return true;
            }
            st.add(n);
        }
        return false;
    }
}