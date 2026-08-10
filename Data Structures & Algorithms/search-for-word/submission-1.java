class Solution {
    int[][] dir = {{-1,0}, {0,-1},{1,0}, {0,1}};
    int m ;
    int n ;
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;

        for(int i = 0; i < m ; i++){
            for(int j = 0; j < n ; j++){
                if(dfs(board, i, j , word, 0)){
                    return true;
                }
            }
        }
        return false;
    }


    private boolean dfs(char[][] board, int i , int j , String word, int si){
        if(si == word.length()){
            return true;
        }

        if(i < 0 || i >= m || j < 0 || j >= n || board[i][j] != word.charAt(si)){
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '&';

        for(int[] d : dir){
            int i_ = d[0] + i;
            int j_ = d[1] + j;

            if(dfs(board, i_, j_, word, si+1)){
                return true;
            }
        }
        board[i][j] = temp;
        return false;
    }
}
