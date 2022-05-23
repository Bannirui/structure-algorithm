/*
 * @lc app=leetcode.cn id=622 lang=java
 *
 * [622] 设计循环队列
 */

// @lc code=start
class MyCircularQueue {

    // 数据
    int[] data;
    // 队首
    int firIdx;
    // 容量
    int cap;
    // 数量
    int size;

    public MyCircularQueue(int k) {
        this.cap=k;
        this.data=new int[k];
        this.firIdx=0;
        this.size=0;
    }
    
    public boolean enQueue(int value) {
        if(this.isFull()) return false;
        this.size++;
        int lastIdx = (this.firIdx+this.size-1)%this.cap;
        this.data[lastIdx] = value;
        return true;
    }
    
    public boolean deQueue() {
        if(this.isEmpty()) return false;
        this.firIdx = (this.firIdx+1)%this.cap;
        this.size--;
        return true;
    }
    
    public int Front() {
        if(this.isEmpty()) return -1;
        return this.data[this.firIdx];
    }
    
    public int Rear() {
        if(this.isEmpty()) return -1;
        int lastIdx = (this.firIdx+this.size-1)%this.cap;
        return this.data[lastIdx];
    }
    
    public boolean isEmpty() {
        return this.size==0;
    }
    
    public boolean isFull() {
        return this.size==this.cap;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
// @lc code=end

