class Solution {
    public int lengthOfLongestSubstring(String s) {
        int oMax = 0;
        int i = 0;
        int j = 0;
        int n = s.length();
        Set<Character> st = new HashSet<>();

        while(i < n){
            while(!st.isEmpty() && st.contains(s.charAt(i))){
                st.remove(s.charAt(j));
                j++;
            }
            st.add(s.charAt(i));
            oMax = Math.max(oMax, i - j + 1);
            i++;
        }
        return oMax;
    }
}
