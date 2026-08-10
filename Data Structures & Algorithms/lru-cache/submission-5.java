class LRUCache {
    class Node{
        int key;
        int value;
        Node prev;
        Node next;
        
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    Map<Integer, Node> mp;
    int capacity;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        mp = new HashMap<>();
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!mp.containsKey(key)) {
            return - 1;
        }

        Node node = mp.get(key);
        remove(node);
        add(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(mp.containsKey(key)){
            Node nodeToBeDeleted = mp.get(key);
            remove(nodeToBeDeleted);
        }
        Node newNode = new Node(key, value);
        mp.put(key, newNode);
        add(newNode);

        if(mp.size() > capacity){
            Node deletedNode = head.next;
            remove(deletedNode);
            mp.remove(deletedNode.key);
        }
    }

    public void remove(Node node){
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    public void add(Node node){
        node.next = tail;
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
    }
}
