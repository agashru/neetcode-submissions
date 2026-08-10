class Solution {
    public boolean isMatch(String s, String p) {
        int m = p.length();
        int n = s.length();

        boolean[][] dp = new boolean[m+1][n+1];

        for(int i = 0; i <= m ; i++){
            for(int j = 0; j <= n ; j++){
                if(i == 0 && j == 0){
                    dp[i][j] = true;
                } else if(i == 0){
                    dp[i][j] = false;
                } else if (j == 0){
                     char patternch = p.charAt(i-1);
                     if(patternch == '*'){
                        dp[i][j] = dp[i-2][j];
                     }else{
                        dp[i][j] = false;
                     }
                } else{
                    char pc = p.charAt(i-1);
                    char sc = s.charAt(j-1);

                    if(pc == '*'){
                        dp[i][j] = dp[i-2][j];
                        char plc = p.charAt(i-2);
                        if(plc == '.' || plc == sc){
                            dp[i][j] = dp[i][j] || dp[i][j-1];
                        }
                    }else if (pc == '.' || pc == sc){
                        dp[i][j] = dp[i-1][j-1];
                    }else{
                        dp[i][j] = false;
                    }
                }
            }
        }
        return dp[m][n];
    }
}
