class Solution {
    int m ;
    int n;
    int[][] dir = {{-1,0}, {0,-1}, {0,1}, {1,0}};
    public int numIslands(char[][] grid) {
        if(grid.length == 0) {
            return 0;
        }

        m = grid.length;
        n = grid[0].length;
        int count = 0;

        for(int i = 0; i< m; i++){
            for(int j = 0; j < n ; j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(char[][] board, int i , int j){
        if(i < 0 || i >= m || j < 0 || j >= n || board[i][j] != '1'){
            return;
        }

        board[i][j] = '&';
        for(int[] d : dir) {
            int i_ = d[0] + i;
            int j_ = d[1] + j;
            dfs(board, i_, j_);
        }
    }
}
