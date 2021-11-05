/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU 缓存机制
 */

// @lc code=start
class LRUCache {

    private int capacity;
    private int size;
    private Map<Integer, Node> map = new HashMap<>();

    private Node dummyHead;
    private Node dummyTail;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        // 虚拟节点
        this.dummyHead=new Node();
        this.dummyTail=new Node();
        this.dummyHead.next=this.dummyTail;
        this.dummyTail.prev=this.dummyHead;
    }
    
    public int get(int key) {
        if(this.size==0||!this.map.containsKey(key)){
            return -1;
        }
        // 获取节点
        Node curNode = this.map.get(key);
        // 从链表中移除节点
        this.removeNode(curNode);
        // 挂到链表头
        this.add2Head(curNode);
        // 节点
        return curNode.value;
    }
    
    public void put(int key, int value) {
        Node curNode = this.map.get(key);
        if(curNode==null){
            // 新增
            // 加入新节点
            Node pending4Add = new Node(key, value);
            // 加入链表头
            this.add2Head(pending4Add);
            // 加入map
            this.map.put(key, pending4Add);
            // 大小+1
            this.size++;
            if(this.size>this.capacity){
                // 移除链表最后一个节点
                Node pending4Remove = this.removeLast();
                // 从map中移除
                this.map.remove(pending4Remove.key);
            }
        }else{
            // 更新
            curNode.value=value;
            // 从链表中移除节点
            this.removeNode(curNode);
            // 挂到链表头
            this.add2Head(curNode);
        }
    }

    // 从链表中移除节点
    private void removeNode(Node node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }

    // 添加到链表头
    private void add2Head(Node node){
        node.next = this.dummyHead.next;
        this.dummyHead.next.prev = node;

        node.prev=this.dummyHead;
        this.dummyHead.next=node;
    }

    // 移除尾节点
    private Node removeLast(){
        Node pending4Remove = this.dummyTail.prev;
        // 移除
        this.removeNode(pending4Remove);
        return pending4Remove;
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

