class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> mp = new HashMap<>();
        
        for(String s :strs){
            int[] count = new int[26];
            for(Character c : s.toCharArray()){
                count[c - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for(int i = 0 ; i < 26; i++){
                sb.append(count[i]);
                sb.append('#');
            }

            String key = sb.toString();
            mp.putIfAbsent(key, new ArrayList<>());
            mp.get(key).add(s);
        }

        return new ArrayList<>(mp.values());
        
    }
}
