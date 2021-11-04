/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 */

// @lc code=start
class Solution {
    public int findKthLargest(int[] nums, int k) {
        // 小根堆
        Queue<Integer> q = new PriorityQueue<>((num1, num2)->{
            return num1-num2;
        });
        for(int num: nums){
            q.offer(num);
            if(q.size()>k){
                q.poll();
            }
        }
        return q.isEmpty()?-1:q.poll();
    }
}
// @lc code=end

