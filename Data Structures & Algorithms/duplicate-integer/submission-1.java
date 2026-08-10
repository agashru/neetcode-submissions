
class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> map = new HashSet<Integer>();
            for(int n : nums){
                    if(map.contains(n)){
                        return true;
                    }else{
                        map.add(n);
                    }
            }
            return false;
    }
}
