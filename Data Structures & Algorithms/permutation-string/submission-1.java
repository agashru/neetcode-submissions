class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int k = s1.length();
        int[] freq_1 = new int[26];
        for(char ch : s1.toCharArray()){
            freq_1[ch - 'a']++;
        }

        int i = 0; int j = 0; int n = s2.length();
        int[] freq_2 = new int[26];
        while(i < n){
            char ch1 = s2.charAt(i);
            freq_2[ch1 - 'a']++;

            if(i - j + 1 > k){
                freq_2[s2.charAt(j) - 'a']--;
                j++;
            }

            if(Arrays.equals(freq_1, freq_2)){
                return true;
            }
            i++;
        }
        return false;
    }
}
