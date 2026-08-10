class Node{
    int key;
    int value;
    Node next;
    Node prev;
    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}
class LRUCache {
    Map<Integer, Node> map;
    int capacity;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1,-1);
        this.head.next = tail;
        this.tail.prev = head;
        
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }

        Node node = map.get(key);
        removeNode(node);
        addNode(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node nodeToBeDeleted = map.get(key);
            removeNode(nodeToBeDeleted);
        }

        //Add the key and value
        Node newNode = new Node(key, value);
        map.put(key, newNode);
        addNode(newNode);

        if(map.size() > capacity){
            Node nodeToBeDeleted = head.next;
            removeNode(nodeToBeDeleted);
            map.remove(nodeToBeDeleted.key);
        }
    }

    private void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addNode(Node node){
        Node previousNode = tail.prev;
        previousNode.next = node;
        node.next = tail;
        node.prev = previousNode;
        tail.prev = node;
    }
}
