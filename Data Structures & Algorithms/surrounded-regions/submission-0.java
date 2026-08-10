class Solution {
     int m;
     int n;
     int[][] dir = {{-1,0}, {0,-1}, {1,0}, {0,1}};
    public void solve(char[][] board) {
      m  = board.length;
      n = board[0].length;
      int[][] visited = new int[m][n];

      for(int j = 0; j < n ; j++){

        if(board[0][j] == 'O' && visited[0][j] == 0){
            dfs(board, 0, j , visited);
        }

        if(board[m-1][j] == 'O' && visited[m-1][j] == 0){
            dfs(board, m-1, j , visited);
        }
      }

      for(int i = 0; i < m ; i++){
        if(board[i][0] == 'O' && visited[i][0] == 0){
            dfs(board, i, 0, visited);
        }

        if(board[i][n-1] == 'O' && visited[i][n-1] == 0){
            dfs(board, i, n-1 , visited);
        }
      }

      for(int i =0; i < m ; i++){
        for(int j = 0; j < n ; j++){
            if(board[i][j] == 'O' && visited[i][j] == 0){
                board[i][j] = 'X';
            }
        }
      }
    }

    public void dfs(char[][] board, int i , int j , int[][] visited){
        if(i < 0 || i >= m || j < 0 || j >= n || visited[i][j] == 1 || board[i][j] != 'O'){
            return ;
        }

        visited[i][j] = 1;
        for(int[] d : dir){
            int i_ = i + d[0];
            int j_ = j + d[1];
            dfs(board, i_ , j_, visited);
        }
    }
}
