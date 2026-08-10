class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> mp = new HashMap<>();
        mp.put(']', '[');
        mp.put('}', '{');
        mp.put(')', '(');
        Stack<Character> st = new Stack<>();

        for(Character c : s.toCharArray()){
            if(mp.containsKey(c)){
                Character poppedCh = st.isEmpty() ? '#' : st.pop();
                if(!mp.get(c).equals(poppedCh)){
                    return false;
                }
            } else{
                st.push(c);
            }
        }
        return st.isEmpty();
    }
}
