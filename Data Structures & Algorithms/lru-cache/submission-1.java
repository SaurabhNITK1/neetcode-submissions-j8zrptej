class LRUCache {
    Map<Integer, Node> hash; // hash to save (key, reference to Nodes) to retrieve it in O(1) when required
    Node tail; // dummy node to save Least recently used (LRU)
    Node head;
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        hash = new HashMap<>(capacity); 
        tail = new Node(0, 0); 
        head = new Node(0, 0);
        // connect both head and tail on initialization;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(hash.containsKey(key)) {
            removeFromLL(hash.get(key));
            insertInLL(hash.get(key));
            return (hash.get(key)).value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        /* When you insert it becomes most recently used (MRU) and should move to head.
           Along with linked list should also insert in hashMap.
           Also check the capacity. If capacity is full, remove the LRU (least recently used)
        */
        if(hash.containsKey(key)) {
            removeFromLL(hash.get(key));
        }
        Node newNode = new Node(key, value);
        insertInLL(newNode);
        hash.put(key, newNode);

        // remove LRU
        if(hash.size() > capacity) {
            Node lruNode = this.tail.prev;
            removeFromLL(lruNode);
            hash.remove(lruNode.key);
        }
    }

    // insert the given node ref in doubly linked list at head
    private void insertInLL(Node nodeRef) {
        nodeRef.next = head.next;
        head.next.prev = nodeRef;
        head.next = nodeRef;
        nodeRef.prev = head;
    }

    // remove in doubly linked list
    private void removeFromLL(Node nodeToRemove) {
        Node prevNode = nodeToRemove.prev;
        Node nextNode = nodeToRemove.next;

        // node removal 
        prevNode.next = nextNode;
        if(nextNode != null) { // take care of tail node
          nextNode.prev = prevNode;
        }
    }
}

class Node {
    Node prev;
    Node next;
    int key;
    int value;

    public Node(int key, int value) {
        this.prev = null;
        this.next = null;
        this.key = key;
        this.value = value;
    }
}
