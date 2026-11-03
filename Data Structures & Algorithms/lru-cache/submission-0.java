class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    final Map<Integer, Node> cache;
    final int cap;
    final Node left;
    final Node right;

    public LRUCache(int capacity) {
        this.cache = new HashMap<>();
        this.cap = capacity;
        this.left = new Node(0, 0);
        this.right = new Node(0, 0);
        this.left.next = this.right;
        this.right.prev = this.left;
    }
    
    public int get(int key) {
        if (!this.cache.containsKey(key)) {
            return -1;
        }
        final Node node = this.cache.get(key);
        remove(node);
        insert(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (this.cache.containsKey(key)) {
            remove(this.cache.get(key));
        }
        final Node newNode = new Node(key, value);
        this.cache.put(key, newNode);
        insert(newNode);
        if (this.cache.size() > this.cap) {
            final Node lru = this.left.next;
            remove(lru);
            this.cache.remove(lru.key);
        }
    }

    private void insert(final Node node) {
        final Node prev = this.right.prev;
        prev.next = node;
        node.prev = prev;
        node.next = this.right;
        this.right.prev = node;
    }

    private void remove(final Node node) {
        final Node prev = node.prev;
        prev.next = node.next;
        node.next.prev = prev;
    }
}







