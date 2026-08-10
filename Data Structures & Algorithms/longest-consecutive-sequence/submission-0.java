class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int n : nums){
            set.add(n);
        }

        int longestStreak = 0;
        for(int n : set){
            if(!set.contains(n-1)){
                int currentStreak = 1;
                int currentElement = n;

                while(set.contains(currentElement +1)){
                    currentElement +=1;
                    currentStreak +=1 ;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}
