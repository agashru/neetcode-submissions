class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        int[] indegree = new int[n];
        List<Integer>[] g = new ArrayList[n];

        for(int i = 0; i < n ;i++){
            g[i] = new ArrayList<>();
        }


        for(int[] p : prerequisites){
            int u = p[0];
            int v = p[1];

            g[v].add(u);
            indegree[u]++;
        }

        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        for(int i = 0; i < n ; i++){
            if(indegree[i] == 0){
                q.add(i);
                count++;
            }
        }
        int[] res = new int[n];
        int k = 0;

        while(!q.isEmpty()){
            int curr = q.poll();
            res[k++] = curr;

            for(int n1 : g[curr]){
                indegree[n1]--;

                if(indegree[n1] == 0){
                    q.add(n1);
                    count++;
                }
            }
        }

        if(count != numCourses){
            return new int[0];
        }
        return res;
    }
}
