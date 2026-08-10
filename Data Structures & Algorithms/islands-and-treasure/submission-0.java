class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] dir = {{-1, 0}, {0,-1}, {0,1}, {1,0}};

        for(int i = 0; i< m; i++){
            for(int j = 0; j < n;j ++){
                if(grid[i][j] == 0){
                    q.add(new int[] {i, j});
                }
            }
        }

        if(q.size() < 0) return;

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int i = curr[0];
            int j = curr[1];
            for(int[] d : dir){
                int i_ = d[0] + i;
                int j_ = d[1] + j;
                if(i_ < 0 || i_ >= m || j_ < 0 || j_ >=n || grid[i_][j_] != Integer.MAX_VALUE){
                    continue;
                }
                q.add(new int[] {i_, j_});
                grid[i_][j_] = grid[i][j]  + 1;
            }
        }
    }
}
