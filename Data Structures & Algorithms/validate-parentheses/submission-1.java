class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> mp = new HashMap<>();
        mp.put(')', '(');
        mp.put('}', '{');
        mp.put(']', '[');

        Stack<Character> st = new Stack<>();

        for(char ch : s.toCharArray()){
            if(mp.containsKey(ch)){
               char ch1 =  st.isEmpty() ? '#' : st.pop();
               if(mp.get(ch) != ch1){
                return false;
               }
            } else{
                st.push(ch);
            }
        }
        return st.isEmpty();
    }
}
