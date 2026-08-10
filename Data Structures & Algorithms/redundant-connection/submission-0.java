class Solution {
    public class DSU{
        int[] parent;
        int[] rank;
        int count;

        public DSU(int n){
            parent = new int[n + 1];
            rank = new int[n + 1];
            count = n;
            for(int i = 1 ; i <= n; i++){
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public int find(int i){
            if(i == parent[i]){
                return i;
            }
            return parent[i] = find(parent[i]);
        }

        public boolean union(int i , int j){
            int i_parent = find(i);
            int j_parent = find(j);

            if(i_parent == j_parent){
                return false;
            }

            if(rank[i_parent] > rank[j_parent]){
                parent[j_parent] = i_parent;
            } else if(rank[j_parent] > rank[i_parent]) {
                parent[i_parent] = j_parent;
            } else{
                parent[j_parent] = i_parent;
                rank[i_parent]++;
            }
            return true;
        }

        public int component(){
            return count;
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DSU d = new DSU(n);

        for(int[] e : edges){
            if(d.find(e[0]) == d.find(e[1])) {
                return e;
            }
            d.union(e[0], e[1]);
        }
        return new int[0];
    }
}
