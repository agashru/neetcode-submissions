class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dir = {{-1,0}, {0,-1}, {1,0}, {0,1}};
        int fresh = 0;

        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < m ;i++) {
            for(int j = 0; j < n ;j++){
                if(grid[i][j] == 2){
                    q.add(new int[] {i, j});
                } else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        if(fresh == 0){
            return 0;
        }
        int time = 0;
        while(!q.isEmpty()){
            int size = q.size();
            time++;

            for(int k = 0; k < size; k++){
                int[] curr = q.poll();
                int i = curr[0];
                int j = curr[1];
                for(int[] d : dir){
                    int i_ = d[0] + i;
                    int j_ = d[1] + j;
                    if(i_ >= 0 && i_ < m && j_ >= 0 && j_ < n && grid[i_][j_] == 1){
                        grid[i_][j_] = 2;
                        fresh --;
                        q.add(new int[] {i_, j_});
                    }
                }
                
            }
        }

        return fresh == 0 ? time - 1: -1;


    }
}
