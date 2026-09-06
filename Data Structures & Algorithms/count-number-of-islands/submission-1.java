class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] visited = new int[m][n];
        int count = 0;
        for(int i = 0; i < m ; i++){
            for(int j = 0; j < n ; j++){
                if(grid[i][j] == '1' && visited[i][j] == 0){
                    bfs(grid, visited, i , j);
                    count++;
                }
            }
        }
        return count;
    }


    public void bfs(char[][] grid, int[][] visited, int i , int j){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {i,j});
        visited[i][j] = 1;
       int[] row = {0,-1,0,1};
       int[] col = {-1,0,1,0};
         int m = grid.length;
        int n = grid[0].length;
        while(!q.isEmpty()){
            int[] node = q.poll();
            int row1 = node[0];
            int col1= node[ 1];

            for(int k = 0; k < 4; k++){
                int row_ = row1 + row[k];
                int col_ = col1 + col[k];


                if(row_ >= 0 && row_ < m && col_ >=0 && col_ < n && visited[row_][col_] == 0 && grid[row_][col_] == '1'){
                    q.add(new int[]{row_,col_});
                    visited[row_][col_] = 1;
                }
            }
            
        }
    }
}
