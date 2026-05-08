class LinkedListNode {

    int key;
    int value;

    LinkedListNode prev;
    LinkedListNode next;

    LinkedListNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {

    private HashMap<Integer, LinkedListNode> map;

    private LinkedListNode head;
    private LinkedListNode tail;

    private int capacity;

    public LRUCache(int capacity) {

        this.capacity = capacity;

        map = new HashMap<>();
        head = new LinkedListNode(0, 0);
        tail = new LinkedListNode(0, 0);

        head.next = tail;
        tail.prev = head;
    }
    private void deleteNode(LinkedListNode node) {

        LinkedListNode prevNode = node.prev;
        LinkedListNode nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    private void addToFront(LinkedListNode node) {

        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    public int get(int key) {

        if (!map.containsKey(key)) {
            return -1;
        }

        LinkedListNode node = map.get(key);
        deleteNode(node);
        addToFront(node);

        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {

            LinkedListNode node = map.get(key);

            node.value = value;
            deleteNode(node);
            addToFront(node);
        }

        else {
            if (map.size() == capacity) {

                LinkedListNode lru = tail.prev;

                deleteNode(lru);

                map.remove(lru.key);
            }

            LinkedListNode newNode = new LinkedListNode(key, value);

            addToFront(newNode);

            map.put(key, newNode);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */