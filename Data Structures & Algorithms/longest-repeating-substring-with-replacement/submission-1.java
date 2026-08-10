class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int i = 0; 
        int j = 0;
        int oMax = 0;
        int maxFreq = 0;
        int[] freq = new int[26];

        while(i < n){
            char ch = s.charAt(i);
            freq[ch - 'A']++;
            maxFreq = Math.max(maxFreq, freq[ch - 'A']);
            int length = i - j + 1;

            if(length - maxFreq > k){
                freq[s.charAt(j) - 'A']--;
                j++;
            }
            length = i - j + 1;
            oMax = Math.max(oMax, length);
            i++;
        }
        return oMax;
    }
}
