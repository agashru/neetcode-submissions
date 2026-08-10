class Solution {
    int m ;
    int n ;
    int[][] dir = {{-1,0}, {0,-1}, {1,0}, {0,1}};

    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;

        int[][] dp = new int[m][n];
        int oMax = 0;

        for(int i = 0; i < m ; i++){
            for(int  j = 0 ; j < n ; j++){
                oMax = Math.max(oMax, dfs(matrix, i, j, dp));
            }
        }
        return oMax;
    }

    public int dfs(int[][] matrix, int i , int j , int[][] dp){
        if(dp[i][j] != 0){
            return dp[i][j];
        }


        for(int[] d : dir){
            int i_ = d[0] + i;
            int j_ = d[1] + j;
            if(i_ >= 0 && i_ < m && j_ >= 0 && j_ < n && matrix[i_][j_] > matrix[i][j]){
                dp[i][j] = Math.max(dp[i][j] , dfs(matrix, i_ , j_ , dp));
            }
        }
        return ++dp[i][j];
    }
}
