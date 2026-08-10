class Solution {
    List<String> result;
    public List<String> letterCombinations(String digits) {
        result = new ArrayList<>();

        if(digits.length() == 0){
            return result;
        }

        Map<Character, String> mp = new HashMap<>();        
        mp.put('2', "abc");
        mp.put('3', "def");
        mp.put('4', "ghi");
        mp.put('5', "jkl");
        mp.put('6', "mno");
        mp.put('7', "pqrs");
        mp.put('8', "tuv");
        mp.put('9', "wxyz");
        
        StringBuilder sb = new StringBuilder();       
        solve(0, digits, sb, mp);        
        return result;
    }

    public void solve(int idx , String digit, StringBuilder sb, Map<Character, String> mp){
        if(idx == digit.length()){
            result.add(sb.toString());
            return ;
        }

        char ch = digit.charAt(idx);
        String str = mp.get(ch);

        for(int i = 0; i < str.length(); i++){
            sb.append(str.charAt(i));
            solve(idx + 1, digit, sb, mp);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
