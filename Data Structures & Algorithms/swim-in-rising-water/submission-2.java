class Solution {
    public class Pair{
        int row;
        int col;
        int elevation;
        public Pair(int row, int col, int elevation){
            this.row = row;
            this.col = col;
            this.elevation = elevation;
        }
    }
    public int swimInWater(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0,1}};

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b) -> Integer.compare(a.elevation , b.elevation)
        );

        pq.add(new Pair(0, 0, grid[0][0]));
        boolean[][] visited = new boolean[n][n];

        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int i = curr.row;
            int j = curr.col;

            if(i == m - 1 && j == n - 1){
                return curr.elevation;
            }

            if(visited[i][j]){
                continue;
            }
            visited[i][j] = true;

            for(int[] d : dir){
                int i_ = i + d[0];
                int j_ = j + d[1];

                if(i_ < 0 || i_ >= grid.length || j_ < 0 || j_ >= n || visited[i_][j_]){
                    continue;
                }

                pq.add(new Pair(i_, j_, Math.max(curr.elevation , grid[i_][j_])));
            }

        }
        return 0;

    }
}
