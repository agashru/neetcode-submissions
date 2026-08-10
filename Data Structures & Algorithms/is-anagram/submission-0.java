class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
            for(int i = 0; i < s.length() ; i++){
              Character sourceCharacter = s.charAt(i);  
              Character targetCharacter = t.charAt(i);  
                map.put(sourceCharacter, map.getOrDefault(sourceCharacter, 0) +1);
                map.put(targetCharacter, map.getOrDefault(targetCharacter, 0) -1);
            }
        Integer zero = new Integer(0);
    for (Integer i : map.values()) {
        if (!zero.equals(i)) {
            return false;
        }
    }
    return true;
    }
}
