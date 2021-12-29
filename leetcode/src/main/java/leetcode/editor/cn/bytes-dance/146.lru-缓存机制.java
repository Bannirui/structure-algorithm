/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU 缓存机制
 */

// @lc code=start
class LRUCache {

    private Map<Integer, Node> map = new HashMap<>();
    private Node head;
    private Node tail;
    private int capacity;
    private int size;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        this.size=0;
        // init double linkedList
        this.head=new Node();
        this.tail=new Node();
        this.head.next=this.tail;
        this.tail.prev=this.head;
    }
    
    public int get(int key) {
        if(this.map.containsKey(key)){
            Node node = this.map.get(key);
            // rebuild linkedList
            this.removeNode(node);
            this.addNode2First(node);
            return node.val;
        }else{
            // key not found
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(this.capacity<=0){
            throw new RuntimeException("error cause of capacity");
        }
        // node construct
        Node node = new Node(key, value);
        // key exist
        if(this.map.containsKey(key)){
            // update
            Node oldNode = this.map.remove(key);
            this.removeNode(oldNode);
            this.size--;
        }
        if(this.size+1>this.capacity){
            Node oldNode = this.removeLastNode();
            this.map.remove(oldNode.key);
            this.size--;
        }
        this.map.put(key, node);
        this.addNode2First(node);     
        this.size++;   
    }

    private void removeNode(Node node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
        node.prev=null;
        node.next=null;
    }

    private void addNode2First(Node node){
        node.next=this.head.next;
        this.head.next.prev=node;
        this.head.next=node;
        node.prev=this.head;
    }

    private Node removeLastNode(){
        Node ret=this.tail.prev;
        ret.prev.next=this.tail;
        this.tail.prev=ret.prev;
        ret.next=null;
        ret.prev=null;
        return ret;
    }

    // node for double-linkedlist
    private static class Node{
        private Node prev;
        private int key;
        private int val;
        private Node next;

        public Node() {
            
        }
        public Node(int key, int val){
            this.key=key;
            this.val=val;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

