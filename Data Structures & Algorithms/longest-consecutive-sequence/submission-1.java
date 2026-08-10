class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Boolean> mp = new HashMap<>();
        for(int n : nums){
            mp.put(n , Boolean.FALSE);
        }

        int oMax = 0;
        for(int n : nums){
            int count = 1;
            int next = n + 1;

            while(mp.containsKey(next) && mp.get(next) == false){
                count++;
                mp.put(next, Boolean.TRUE);
                next++;
            }

            int prev = n -1;
            while(mp.containsKey(prev) && mp.get(prev) == false){
                count++;
                mp.put(prev, Boolean.TRUE);
                prev--;
            }
            oMax = Math.max(count, oMax);
        }
        return oMax;
    }
}
