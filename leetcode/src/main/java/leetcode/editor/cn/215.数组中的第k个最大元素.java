import java.util.Queue;

/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 */

// @lc code=start
class Solution {
    public int findKthLargest(int[] nums, int k) {
        // 堆排
        // base case
        if (nums == null || nums.length == 0) {
            return -1;
        }
        // 小顶堆
        Queue<Integer> smallHeap = new PriorityQueue<>();
        // 遍历元素
        for (int num : nums) {
            smallHeap.offer(num);
            if (smallHeap.size() > k) {
                smallHeap.poll();
            }
        }
        return smallHeap.isEmpty() ? -1 : smallHeap.peek();
    }
}
// @lc code=end
