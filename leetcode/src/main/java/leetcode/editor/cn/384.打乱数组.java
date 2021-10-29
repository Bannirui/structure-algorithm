import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * @lc app=leetcode.cn id=384 lang=java
 *
 * [384] 打乱数组
 */

// @lc code=start
class Solution {

    // 原始数据
    private int[] originArr;

    // 操作数据
    private int[] opArr;

    private Random random = new Random();

    public Solution(int[] nums) {
        this.originArr = new int[nums.length];
        this.opArr = new int[nums.length];
        this.deepCopy(nums, this.originArr);
    }

    public int[] reset() {
        return this.originArr;
    }

    public int[] shuffle() {
        // 列表
        List<Integer> list = this.copyArrAsList(this.originArr);
        for (int i = 0; i < this.originArr.length; i++) {
            // 随机脚标
            // 当前列表长度size 随机[0...size-1]
            int curSize = list.size();
            int randomIdx = this.random.nextInt(curSize);
            int randomVal = list.get(randomIdx);
            // 用最后的元素填补漏洞 移除末尾元素
            int lastIdx = curSize - 1;
            int lastVal = list.get(lastIdx);
            list.set(randomIdx, lastVal);
            list.remove(lastIdx);
            this.opArr[i] = randomVal;
        }
        return this.opArr;
    }

    private List<Integer> copyArrAsList(int[] src) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < src.length; i++) {
            res.add(src[i]);
        }
        return res;
    }

    // 拷贝数组
    private void deepCopy(int[] src, int[] dest) {
        int len = src.length;
        for (int i = 0; i < len; i++) {
            dest[i] = src[i];
        }
    }
}

/**
 * Your Solution object will be instantiated and called as such: Solution obj =
 * new Solution(nums); int[] param_1 = obj.reset(); int[] param_2 =
 * obj.shuffle();
 */
// @lc code=end
