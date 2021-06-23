import java.util.LinkedList;

/*
 * @Author: dingrui
 * @Date: 2021-06-23 11:08:23
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-23 11:23:38
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=706 lang=java
 *
 * [706] 设计哈希映射
 */

// @lc code=start
class MyHashMap {

    // node
    class MyHashMapNode {
        Integer key;
        Integer value;

        public MyHashMapNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // 数组容量
    private static final int DATA_CAP = 128;

    // 数组
    private LinkedList[] data;

    /** Initialize your data structure here. */
    public MyHashMap() {
        this.data = new LinkedList[DATA_CAP];
        for (int i = 0; i < DATA_CAP; i++) {
            this.data[i] = new LinkedList<MyHashMapNode>();
        }
    }

    // hash
    private int myHash(int key) {
        return key % DATA_CAP;
    }

    private boolean contains(int key) {
        // hash
        int index = this.myHash(key);
        LinkedList<MyHashMapNode> cur = this.data[index];
        if (cur.isEmpty()) {
            return false;
        }
        // 遍历
        for (int i = 0; i < cur.size(); i++) {
            MyHashMapNode node = cur.get(i);
            if (node.key == key) {
                return true;
            }
        }
        return false;
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        // hash
        int index = this.myHash(key);
        // 是否存在key
        if (this.contains(key)) {
            // 更新
            LinkedList<MyHashMapNode> cur = this.data[index];
            // 遍历
            for (int i = 0; i < cur.size(); i++) {
                MyHashMapNode node = cur.get(i);
                if (node.key == key) {
                    node.value = value;
                    return;
                }
            }
        } else {
            // 添加
            this.data[index].addLast(new MyHashMapNode(key, value));
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        if (this.contains(key)) {
            // hash
            int index = this.myHash(key);
            LinkedList<MyHashMapNode> cur = this.data[index];
            for (int i = 0; i < cur.size(); i++) {
                MyHashMapNode node = cur.get(i);
                if (node.key == key) {
                    return node.value;
                }
            }
            return -1;
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        if (this.contains(key)) {
            // hash
            int index = this.myHash(key);
            LinkedList<MyHashMapNode> cur = this.data[index];
            for (int i = 0; i < cur.size(); i++) {
                MyHashMapNode node = cur.get(i);
                if (node.key == key) {
                    cur.remove(node);
                    return;
                }
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
// @lc code=end
