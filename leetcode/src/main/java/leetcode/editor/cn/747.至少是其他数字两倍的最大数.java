import java.util.PriorityQueue;

/*
 * @Author: dingrui
 * @Date: 2021-06-28 14:35:18
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-28 14:43:17
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=747 lang=java
 *
 * [747] 至少是其他数字两倍的最大数
 */

// @lc code=start
class Solution {

    class HeapNode {
        // 值
        private int num;
        // 值在数组中对应的下标
        private int index;

        public HeapNode(int num, int index) {
            this.num = num;
            this.index = index;
        }
    }

    public int dominantIndex(int[] nums) {
        // base case
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return 0;
        }
        // 最大两个数 大根堆
        PriorityQueue<HeapNode> bigHeap = new PriorityQueue<>((o1, o2) -> {
            return o2.num - o1.num;
        });
        for (int i = 0; i < nums.length; i++) {
            bigHeap.add(new HeapNode(nums[i], i));
        }
        HeapNode firMax = bigHeap.poll();
        HeapNode secMax = bigHeap.poll();
        return firMax.num >= (secMax.num << 1) ? firMax.index : -1;
    }
}
// @lc code=end
