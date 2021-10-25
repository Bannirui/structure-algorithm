import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU 缓存机制
 */

// @lc code=start
class LRUCache {

    // 链表节点
    private static class KeyNode {
        private Integer key;
        private Integer value;
        private KeyNode next;
        private KeyNode prev;

        public KeyNode() {

        }

        public KeyNode(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }

    // 容量
    Integer capacity = 0;
    // 当前元素数量
    Integer size = 0;

    // 存储key-value
    Map<Integer, KeyNode> dataMap;

    // 链表存储key
    KeyNode head, tail;

    public LRUCache(int capacity) {
        // 容量
        this.capacity = capacity;
        // 数据容器
        this.dataMap = new HashMap<Integer, KeyNode>();
        // key链表
        this.head = new KeyNode();
        this.tail = new KeyNode();
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public int get(int key) {

        if (!this.dataMap.containsKey(key)) {
            // 不存在key
            return -1;
        }
        // 存在key
        KeyNode node = this.dataMap.get(key);
        // 处理链表
        this.moveToHead(node);
        // 返回
        return node.value;
    }

    public void put(int key, int value) {
        if (this.dataMap.containsKey(key)) {
            // 已经存在key 覆盖
            KeyNode oldNode = this.dataMap.get(key);
            // 覆盖值
            oldNode.value = value;
            // 节点移至链表头
            this.moveToHead(oldNode);
        } else {
            // 新key 添加
            KeyNode newNode = new KeyNode(key, value);
            // 添加到hash表
            this.dataMap.put(key, newNode);
            // 加到链表头节点
            this.addToHead(newNode);
            // 元素数量
            this.size++;
            // 元素数量已经超过阈值
            if (this.size > this.capacity) {
                // 移除链表最后节点
                KeyNode node = this.removeTail();
                // 移除数据
                this.dataMap.remove(node.key);
                // 元素数量调整
                this.size--;
            }
        }
    }

    private void addToHead(KeyNode node) {
        node.prev = this.head;
        node.next = this.head.next;
        this.head.next.prev = node;
        this.head.next = node;
    }

    private KeyNode removeTail() {
        KeyNode last = this.tail.prev;
        this.removeNode(last);
        return last;
    }

    private void removeNode(KeyNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(KeyNode node) {
        this.removeNode(node);
        this.addToHead(node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */
// @lc code=end
