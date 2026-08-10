class Solution {
    public String minWindow(String s, String t) {
        int count = t.length();
        Map<Character, Integer> mp = new HashMap<>();

        for(char ch : t.toCharArray()){
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }

        int i = 0;
        int j = 0;
        int n = s.length();
        int start_j = 0;
        int minLength = Integer.MAX_VALUE;

        while(i < n){
            char ch1 = s.charAt(i);

            if(mp.containsKey(ch1) && mp.get(ch1) > 0){
                count --;
            }
            mp.put(ch1, mp.getOrDefault(ch1, 0) - 1);

            while(count == 0){
                int length = i - j + 1;
                if(length < minLength){
                    minLength = length;
                    start_j = j;
                }
                char ch2 = s.charAt(j);
                mp.put(ch2, mp.getOrDefault(ch2, 0) + 1);
                if(mp.containsKey(ch2) && mp.get(ch2) > 0){
                    count++;
                }
                j++;
            }
            i++;
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(start_j , start_j + minLength);
    }
}
