class Solution {
    int m ;
    int n ;
    int[][] dir = {{-1,0}, {0,-1}, {0,1}, {1,0}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
         m = heights.length;
         n = heights[0].length;

        boolean[][] visitedAtlantic = new boolean[m][n];
        boolean[][] visitedPacific = new boolean[m][n];
        List<List<Integer>> result = new ArrayList<>();

        Queue<int[]> atQ = new LinkedList<>();
        Queue<int[]> pacificQ = new LinkedList<>();

        for(int i = 0; i < m; i++){
            atQ.add(new int[] {i, n-1});
            pacificQ.add(new int[] {i, 0});
        }

        for(int j = 0; j < n; j++){
            atQ.add(new int[] {m-1, j});
            pacificQ.add(new int[] {0, j});
        }

        bfs(atQ, visitedAtlantic, heights);
        bfs(pacificQ, visitedPacific, heights);

        for(int i = 0; i < m ; i++){
            for(int j = 0; j < n; j++){
                if(visitedAtlantic[i][j] && visitedPacific[i][j]){
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    public void bfs(Queue<int[]> q , boolean[][] visited, int[][] heights){
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int i = curr[0];
            int j = curr[1];
            visited[i][j] = true;
            for(int[] d : dir){
                int i_ = d[0] + i;
                int j_ = d[1] + j;

                if(i_ >= 0 && i_ < m && j_ >= 0 && j_ < n && visited[i_][j_] == false &&
                    heights[i_][j_] >= heights[i][j] ){
                        q.add(new int[] {i_, j_});
                    }

            }
        }
    }
}
