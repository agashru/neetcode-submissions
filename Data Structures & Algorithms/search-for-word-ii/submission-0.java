class Solution {
    public class Node{
        Node[] children;
        boolean isEnd;
        String word;

        public Node(){
            children = new Node[26];
            isEnd = false;
            word = "";
        }
    }
    public void insert(String word, Node root) {
        Node curr = root;
        for(char ch : word.toCharArray()){
            if(curr.children[ch - 'a'] == null){
                curr.children[ch - 'a'] = new Node();
            }
            curr = curr.children[ch - 'a'];
        }
        curr.isEnd = true;
        curr.word = word;
    }

    int m;
    int n ;
    int[][] dir = {{-1, 0}, {0,-1}, {0,1}, {1,0}};
    List<String> result;
    public List<String> findWords(char[][] board, String[] words) {
        m = board.length;
        n = board[0].length;
        result = new ArrayList<>();
        Node root = new Node();

        for(String word : words){
            insert(word, root);
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n ; j++) {
                if(root.children[board[i][j] - 'a'] != null){
                    dfs(board, root, i , j);
                }
            }
        }
        return result;
    }

    public void dfs(char[][] board, Node root, int i , int j){
        if(i < 0 || i >= m || j < 0 || j >= n || board[i][j] == '&' ||
        root.children[board[i][j] - 'a'] == null){
            return;
        }
        root = root.children[board[i][j] - 'a'];

        if(root.isEnd){
            result.add(root.word);
            root.isEnd = false;
        }

        char temp = board[i][j];
        board[i][j] = '&';

        for(int[] d : dir){
            int i_ = i + d[0];
            int j_ = j + d[1];
            dfs(board, root, i_, j_);
        }
        board[i][j] = temp;
    }
}
