class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> target = new HashMap<>();
        int[] count = new int[26];
        int maxFreq = 0;
        int start = 0;
        int longestSubString = 0;


        for(int end = 0; end < s.length() ; end ++){
            int currentChar = s.charAt(end) - 'A';
            count[currentChar]++;

            maxFreq = Math.max(maxFreq, count[currentChar]);

            Boolean isValid = end + 1 - start - maxFreq <= k;

            if(!isValid) {
                int outGoing = s.charAt(start) - 'A';
                count[outGoing]--;
                start ++;
            }
            longestSubString = end -start + 1;
        }

        return longestSubString;
    }
}
