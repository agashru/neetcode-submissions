class Solution {
    int m , n;
    int[][] directions = {{-1, 0} , {0, -1}, {0, 1}, {1, 0}};

    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;

        int max = 0;
        int[][] dp = new int[m][n];

        for(int i = 0; i < m ; i++){
            for(int j = 0; j < n ; j++){
                max = Math.max(max, dfs(matrix, i, j, dp));
            }
        }
        return max;
    }

    public int dfs(int[][] matrix, int i , int j , int[][] dp){
        if(dp[i][j] != 0){
            return dp[i][j];
        }

        for(int[] dir : directions){
            int i_ = dir[0] + i;
            int j_ = dir[1] + j;
            if(isSafe(i_, j_) && matrix[i][j] < matrix[i_][j_]){
                dp[i][j] = Math.max(dp[i][j], dfs(matrix, i_, j_, dp));
            }
        }
        return ++dp[i][j];
    }

    public boolean isSafe(int i , int j){
        if(i >= 0 && i < m && j >= 0 && j < n){
            return true;
        } else{
            return false;
        }
    }
}
