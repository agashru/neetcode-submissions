class LRUCache {

    static class Node{
        int key;
        int value;
        Node next;
        Node prev;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private final Map<Integer, Node> map;
    private final Node head;
    private final Node tail;
    private final int capacity;

    public LRUCache(int capacity){
        this.map = new HashMap<>();
        this.capacity = capacity;
        this.head = new Node(0,0);
        this.tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key){
        Node node = map.get(key);
        if(node == null){
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    private void addToHead(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if(node != null){
            node.value = value;
            moveToHead(node);
            return;
        }else{
        Node newNode = new Node(key, value);
        map.put(key, newNode);
        addToHead(newNode);
        if(map.size() > capacity){
            Node evicted = removeFromTail();
            map.remove(evicted.key);
        }
        }
    }

    private Node removeFromTail() {
        Node evicted = tail.prev;
        removeNode(evicted);
        return evicted;
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
        node.next = null;
        node.prev = null;
    }
}
