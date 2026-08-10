class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] freq = new int[26];

        for(char ch : s.toCharArray()){
            freq[ch - 'a']++;
        }


        for(char ch1 : t.toCharArray()){
            freq[ch1 - 'a']--;
            if(freq[ch1 - 'a'] < 0){
                return false;
            }
        }
        return true;
    }
}
