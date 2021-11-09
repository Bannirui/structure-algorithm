/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 */

// @lc code=start
class Solution {
    public int findKthLargest(int[] nums, int k) {
        // 堆排序 小根堆
        Queue<Integer> q = new PriorityQueue<Integer>((n1, n2)->{
            // 升序
            return n1-n2;
        });
        // 遍历元素
        for(int num: nums){
            q.offer(num);
            // 维持最多k个元素
            if(q.size()>k){
                q.poll();
            }
        }
        return q.isEmpty()? -1: q.poll();
    }
}
// @lc code=end

