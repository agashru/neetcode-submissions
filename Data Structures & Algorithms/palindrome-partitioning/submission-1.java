class Solution {
    public List<List<String>> partition(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for(int g = 0; g < dp.length ; g++){
            for(int i =0, j = g ; j < dp[0].length ; i++, j++){
                if(g == 0){
                    dp[i][j] = true;
                } else if(g == 1){
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else{
                    if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1]){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = false;
                    }
                }
            }
        }
        List<List<String>> result = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        solve(s, result, temp, 0, dp);
        return result;
    }

    public void solve(String s, List<List<String>> result, List<String> temp, int i , boolean[][] dp){
        if(i == s.length()){
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int j = i ; j < s.length(); j++){
            if(dp[i][j]){
                temp.add(s.substring(i, j+1));
                solve(s, result, temp, j + 1, dp);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
