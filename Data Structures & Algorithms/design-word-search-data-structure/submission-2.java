class WordDictionary {
    public class Node{
        Node[] children;
        boolean isEnd;

        public Node(){
            children = new Node[26];
            isEnd = false;
        }

        public boolean find(String word, int i) {
            if(i == word.length()){
                return isEnd;
            }

            char ch = word.charAt(i);
            if(ch == '.'){
                for(Node child : children){
                    if(child != null && child.find(word, i+1)){
                        return true;
                    }
                }
                return false;
            }else{
                if(children[ch - 'a'] == null){
                    return false;
                } else{
                    return children[ch - 'a'].find(word, i + 1);
                }
            }
        }
    }

    Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
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
        return root.find(word, 0);
    }
}
