import java.util.Queue;

/*
 * @Author: dingrui
 * @Date: 2021-07-29 23:07:32
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-29 23:15:02
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 */

// @lc code=start
class Solution {

    public int findKthLargest(int[] nums, int k) {
        // 小顶堆 升序
        Queue<Integer> heap = new PriorityQueue<>((o1, o2) -> {
            return o1 - o2;
        });
        for (int num : nums) {
            heap.offer(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return !heap.isEmpty() ? heap.peek() : -1;
    }
}
// @lc code=end
