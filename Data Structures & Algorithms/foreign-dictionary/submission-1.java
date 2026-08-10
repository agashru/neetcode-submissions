class Solution {
    public String foreignDictionary(String[] words) {
      Map<Character, Set<Character>> mp = new HashMap<>();
      Map<Character, Integer> indegree = new HashMap<>();

      for(String word : words){
        for(Character ch : word.toCharArray()){
            mp.putIfAbsent(ch , new HashSet<>());
            indegree.putIfAbsent(ch , 0);
        }
      }

      int n = words.length;

      for(int i = 0 ; i < n - 1; i++){
        String word1  = words[i];
        String word2 = words[i+1];

        if(word1.length() > word2.length() && word1.startsWith(word2)){
            return "";
        }

        for(int j = 0 ; j < Math.min(word1.length(), word2.length()); j++){
            char ch1 = word1.charAt(j);
            char ch2 = word2.charAt(j);

            if(ch1 != ch2){
                if(!mp.get(ch1).contains(ch2)){
                        mp.get(ch1).add(ch2);
                        indegree.put(ch2, indegree.get(ch2) + 1);
                }
                break;
            }
        }
      }

        StringBuilder sb = new StringBuilder();
        Queue<Character> q = new LinkedList<>();
        for(char ch : indegree.keySet()){
            if(indegree.get(ch) == 0){
                q.add(ch);
            }
        }

        while(!q.isEmpty()){
            Character u = q.poll();
            sb.append(u);

            for(Character v: mp.get(u)){
                indegree.put(v, indegree.get(v) - 1);
                if(indegree.get(v) == 0){
                    q.add(v);
                }
            }
        }

        if(sb.length() != indegree.size()){
            return "";
        }

        return sb.toString();
      }
}
