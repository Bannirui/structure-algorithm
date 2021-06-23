import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * @Author: dingrui
 * @Date: 2021-06-23 09:44:27
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-23 10:02:20
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=703 lang=java
 *
 * [703] 数据流中的第 K 大元素
 */

// @lc code=start
class KthLargest {

    // 数据容器 堆
    Queue<Integer> data;
    // 第k大元素
    private int k;

    public KthLargest(int k, int[] nums) {
        this.data = new PriorityQueue<>();
        this.k = k;
        for (int i = 0; i < nums.length; i++) {
            this.add(nums[i]);
        }
    }

    public int add(int val) {
        // add完元素之后返回第k大的元素
        this.data.offer(val);
        if (this.data.size() > this.k) {
            // 元素数量大于k 出对
            this.data.poll();
        }
        return this.data.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
// @lc code=end
