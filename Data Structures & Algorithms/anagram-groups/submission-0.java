class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> mp = new HashMap<>();
        for(int i = 0; i < strs.length; i++){
            char[] carray = strs[i].toCharArray();
            Arrays.sort(carray);
            String sortedString = Arrays.toString(carray);

            if(!mp.containsKey(sortedString)){
                mp.put(sortedString, new ArrayList<>());                   
            }
             mp.get(sortedString).add(strs[i]);
             
        }
        return new ArrayList<>(mp.values());
        
    }
}
