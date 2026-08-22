class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
     Map<String , List<String>> mp = new HashMap<>();

        for(String s : strs){
            String freqStr = buildFreq(s);
            mp.computeIfAbsent(freqStr, k -> new ArrayList<>())
            .add(s);
        }
        return new ArrayList<>(mp.values());
    }

    public String buildFreq(String s){
        int[] freq = new int[26];
        for(char ch : s.toCharArray()){
            freq[ch - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        char ch = 'a';
        for(int f : freq){
            sb.append(ch);
            sb.append(f);
            ch++;
        }
        return sb.toString();
    }
}
