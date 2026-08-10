class Solution {
    public class DSU{
        int[] parent;
        int[] rank;
        int count;

        public DSU(int n){
            parent = new int[n];
            rank = new int[n];
            count = n;
            for(int i = 0 ; i < n; i++){
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
    public int countComponents(int n, int[][] edges) {
        DSU d = new DSU(n);
        int res = n;
        for(int[] e: edges){
            if(d.union(e[0], e[1])){
                res--;
            }
        }
        return res;

    }
}
