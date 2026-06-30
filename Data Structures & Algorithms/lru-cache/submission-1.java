class LRUCache {

    class Node{
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    int capacity;
    Map<Integer,Node> map;
    Node head;
    Node tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        
        head = new Node(-1,-1);
        tail = new Node(-1,-1);


        head.next = tail;
        tail.prev = head;
    }   

    public void addNode(Node node){
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    public void deleteNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    public void moveToHead(Node node){
        deleteNode(node);
        addNode(node);
    }
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node node = map.get(key);
        moveToHead(node);
        return node.value;
    }
    public Node removeTail(){
        Node node = tail.prev;
        deleteNode(node);
        return node;
    }
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            moveToHead(node);
        }else{
            Node node = new Node(key,value);
            map.put(key,node);
            addNode(node);

            if(map.size() > capacity){
                Node last = removeTail();
                map.remove(last.key);
            }
        }
    }
}
