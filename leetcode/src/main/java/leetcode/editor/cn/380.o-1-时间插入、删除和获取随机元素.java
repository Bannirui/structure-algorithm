import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/*
 * @lc app=leetcode.cn id=380 lang=java
 *
 * [380] O(1) 时间插入、删除和获取随机元素
 */

// @lc code=start
class RandomizedSet {

    // key=val value=idx
    Map<Integer, Integer> idxMap = new HashMap<>();

    // 存放值
    List<Integer> valList = new ArrayList<>();

    Random random = new Random();

    public RandomizedSet() {

    }

    public boolean insert(int val) {
        // 是否存在该值
        if (this.idxMap.containsKey(val)) {
            return false;
        } else {
            // 当前脚标[0...size-1] 下一个脚标size
            int nextSize = this.valList.size();
            this.idxMap.put(val, nextSize);
            this.valList.add(nextSize, val);
            return true;
        }
    }

    public boolean remove(int val) {
        // 是否存在该值
        if (!this.idxMap.containsKey(val)) {
            return false;
        } else {
            // 要删除的脚标
            int pending4DelIdx = this.idxMap.get(val);
            // 用list最后一个元素替代即将出现的空洞
            int lastEle = this.valList.get(valList.size() - 1);
            this.valList.set(pending4DelIdx, lastEle);
            // 更新末尾元素的脚标
            this.idxMap.put(lastEle, pending4DelIdx);
            // 移除list最后一个元素
            int lastIdx = valList.size() - 1;
            this.valList.remove(lastIdx);
            // 删除映射
            this.idxMap.remove(val);
            return true;
        }
    }

    public int getRandom() {
        // 数组脚标
        // 当前有size个元素 脚标[0...size-1]
        Integer randomIdx = this.random.nextInt(this.valList.size());
        return this.valList.get(randomIdx);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet(); boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val); int param_3 = obj.getRandom();
 */
// @lc code=end
