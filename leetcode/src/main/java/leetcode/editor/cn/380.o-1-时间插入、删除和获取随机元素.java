import java.util.HashMap;
import java.util.Map;

/*
 * @Author: dingRui
 * @Date: 2021-08-17 10:46:07
 * @LastEditors: dingRui
 * @LastEditTime: 2021-08-17 13:49:53
 * @Description: 
 */
/*
 * @lc app=leetcode.cn id=380 lang=java
 *
 * [380] O(1) 时间插入、删除和获取随机元素
 */

// @lc code=start
class RandomizedSet {

    private Map<Integer, Integer> key2Index;
    private Map<Integer, Integer> index2Key;
    private int size;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        this.key2Index = new HashMap<>();
        this.index2Key = new HashMap<>();
        this.size = 0;
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (!this.key2Index.containsKey(val)) {
            // 不存在
            this.key2Index.put(val, this.size);
            this.index2Key.put(this.size, val);
            this.size++;
            return true;
        }
        return false;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (this.key2Index.containsKey(val)) {
            // 要删除的值存在 对应的index
            int indexToDel = key2Index.get(val);
            int keyToDel = val;
            // 用最新有效的值替换被删除的产生的index漏洞
            int lastIndex = --this.size;
            int lastKey = this.index2Key.get(lastIndex);
            // 填补漏洞
            this.key2Index.put(lastKey, indexToDel);
            this.index2Key.put(indexToDel, lastKey);
            // 删除
            this.key2Index.remove(keyToDel);
            // 要被删除的index已经被lastIndex覆盖
            this.index2Key.remove(lastIndex);
            return true;
        }
        return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        if (this.size == 0) {
            return -1;
        }
        int random = (int) (Math.random() * this.size);
        return this.index2Key.get(random);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
// @lc code=end
