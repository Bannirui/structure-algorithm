import java.util.Iterator;
import java.util.LinkedList;

import leetcode.editor.cn.ImplementQueueUsingStacks.MyQueue;

/*
 * @Author: dingrui
 * @Date: 2021-06-23 10:05:32
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-23 11:07:30
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=705 lang=java
 *
 * [705] 设计哈希集合
 */

// @lc code=start
class MyHashSet {

    // 数组大小 减少hash碰撞
    private static final int DATA_CAP = 128;

    // 数据容器
    private LinkedList[] data;

    /** Initialize your data structure here. */
    public MyHashSet() {
        this.data = new LinkedList[DATA_CAP];
        // 数组中每个元素就是LinkedList
        for (int i = 0; i < DATA_CAP; i++) {
            data[i] = new LinkedList<Integer>();
        }
    }

    private static int myHash(int key) {
        return key % DATA_CAP;
    }

    public void add(int key) {
        // 该元素已经存在
        if (this.contains(key)) {
            return;
        }
        // 该元素不存在 可以添加
        int index = myHash(key);
        LinkedList<Integer> cur = this.data[index];
        cur.add(key);
    }

    public void remove(int key) {
        // 该元素不存在 无法删除
        if (!this.contains(key)) {
            return;
        }
        // 该元素存在
        int index = myHash(key);
        // 这个地方需要注意 #remove()方法为重载方法 入参int类型为移除对应下标元素 入参Integer类型为移除元素本身
        this.data[index].remove(Integer.valueOf(key));
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        // hash
        int index = myHash(key);
        // 链表中是否已经存在该元素
        LinkedList<Integer> curLinkedList = this.data[index];
        if (curLinkedList.isEmpty()) {
            return false;
        }
        for (int i = 0; i < curLinkedList.size(); i++) {
            if (curLinkedList.get(i) == key) {
                return true;
            }
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
// @lc code=end
