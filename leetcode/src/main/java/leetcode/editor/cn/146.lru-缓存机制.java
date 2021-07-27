import java.util.HashMap;
import java.util.Map;

/*
 * @Author: dingrui
 * @Date: 2021-07-26 16:14:17
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-27 23:32:01
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU 缓存机制
 */

// @lc code=start
class LRUCache {

    // 链表节点
    static class NodeInfo {
        private int key;
        private int value;
        private NodeInfo prev;
        protected NodeInfo next;

        public NodeInfo() {
        }

        public NodeInfo(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, NodeInfo> map = new HashMap<>();;

    // 虚拟节点
    private NodeInfo head;
    private NodeInfo tail;

    private int size;

    private int capacity;

    public LRUCache(int capacity) {
        // hash表存储真实的数据
        this.size = 0;
        this.capacity = capacity;
        this.head = new NodeInfo();
        this.tail = new NodeInfo();
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public int get(int key) {
        // hash表
        NodeInfo v = this.map.get(key);
        if (v == null) {
            return -1;
        }
        // 节点移动到链表head
        this.move2Head(v);
        return v.value;
    }

    public void put(int key, int value) {
        // hash
        NodeInfo v = this.map.get(key);
        if (v == null) {
            // new
            NodeInfo newNode = new NodeInfo(key, value);
            // put
            this.map.put(key, newNode);
            // 添加到链表头部
            add2Head(newNode);
            this.size++;
            if (this.size > this.capacity) {
                // 超容
                NodeInfo removeNode = this.removeTail();
                this.map.remove(removeNode.key);
                this.size--;
            }
        } else {
            // update
            v.value = value;
            this.move2Head(v);
        }
    }

    private void add2Head(NodeInfo node) {
        this.head.next.prev = node;
        node.next = this.head.next;
        node.prev = this.head;
        this.head.next = node;
    }

    private void removeNode(NodeInfo node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void move2Head(NodeInfo node) {
        this.removeNode(node);
        this.add2Head(node);
    }

    private NodeInfo removeTail() {
        NodeInfo node = this.tail.prev;
        this.tail.prev = node.prev;
        node.prev.next = this.tail;
        return node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end
