class Solution {

    int m ;
    int n;
    int[][] dir = {{-1,0}, {0,-1}, {0,1}, {1,0}};
    public int maxAreaOfIsland(int[][] grid) {
        if(grid.length == 0) {
            return 0;
        }

        m = grid.length;
        n = grid[0].length;
        int maxArea = 0;

        for(int i = 0; i< m; i++){
            for(int j = 0; j < n ; j++){
                if(grid[i][j] == 1){
                   int area =  dfs(grid, i, j);
                    maxArea  = Math.max(area, maxArea);
                }
            }
        }
        return maxArea;
    }

    public int dfs(int[][] board, int i , int j){
        if(i < 0 || i >= m || j < 0 || j >= n || board[i][j] != 1){
            return 0;
        }

        board[i][j] = -1;
        int count = 1;

        for(int[] d : dir) {
            int i_ = d[0] + i;
            int j_ = d[1] + j;
            count += dfs(board, i_, j_);
        }
        return count;
    }
}
