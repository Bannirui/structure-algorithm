/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU 缓存机制
 */

// @lc code=start
class LRUCache {

    // 数据存储
    private Map<Integer, Node> dataMap = new HashMap<>();

    // head
    private Node head;

    // tail
    private Node tail;

    private int capacity;

    private int size;

    // 构造方法
    public LRUCache(int capacity) {
        // 初始化链表
        this.head = new Node();
        this.tail = new Node();
        this.head.next = this.tail;
        this.tail.prev = this.head;
        // 容量
        this.capacity = capacity;
        this.size = 0;
    }

    // 根据key取值
    public int get(int key) {
        Node valueNode = null;
        if(this.size==0 || (valueNode = this.dataMap.get(key))==null){
            // 不存在key
            return -1;
        }
        // 存在key 将value移至first
        this.move2Head(valueNode);
        return valueNode.value;
    }
    
    public void put(int key, int value) {
        // 判断更新还是新增
        Node valueNode = null;
        if((valueNode=this.dataMap.get(key))==null){
            // 新增
            valueNode = new Node(key, value);
            // 放进map 挂到头节点
            this.add2Head(valueNode);
            this.dataMap.put(key, valueNode);
            // 判断容量
            if(++this.size>this.capacity){
                Node removeNode = this.removeTail();
                this.dataMap.remove(removeNode.key);
            }
        }else{
            // 更新
            valueNode.value = value;
            this.move2Head(valueNode);
        }
    }

    private void removeNode(Node node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }

    private Node removeTail(){
        Node removeNode = this.tail.prev;
        removeNode.prev.next = this.tail;
        this.tail.prev=removeNode.prev;
        return removeNode;
    }

    private void add2Head(Node node){
        node.next=this.head.next;
        this.head.next.prev=node;
        
        node.prev=this.head;
        this.head.next=node;
    }

    private void move2Head(Node node){
        this.removeNode(node);
        this.add2Head(node);
    }

    // 链表节点
    private static class Node{
        private int key;
        private int value;
        private Node prev;
        private Node next;

        public Node(){}

        public Node(int key, int value){
            this.key=key;
            this.value=value;
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

