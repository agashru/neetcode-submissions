class PrefixTree {
    public class Node{
        Node[] children;
        boolean isEnd;

        public Node(){
            children = new Node[26];
            isEnd = false;
        }
    }
    Node root;
    public PrefixTree() {
         root = new Node();
    }

    public void insert(String word) {
        Node curr = root;
        for(char ch : word.toCharArray()){
            if(curr.children[ch - 'a'] == null){
                curr.children[ch - 'a'] = new Node();
            }
            curr = curr.children[ch - 'a'];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        Node curr = root;
        for(char ch : word.toCharArray()){
            if(curr.children[ch - 'a'] == null){
                return false;
            }
            curr = curr.children[ch - 'a'];
        }
        return curr.isEnd ;
    }

    public boolean startsWith(String prefix) {
        Node curr = root;
        for(char ch : prefix.toCharArray()){
            if(curr.children[ch - 'a'] == null){
                return false;
            }
            curr = curr.children[ch - 'a'];
        }
        return true ;
    }
}
