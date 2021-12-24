/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 */

// @lc code=start
class Solution {
    public int findKthLargest(int[] nums, int k) {
        // small heap
        Queue<Integer> heap = new PriorityQueue<>((o1, o2)->{
            return o1.compareTo(o2);
        });
        for(int i=0;i<nums.length;i++){
            heap.offer(nums[i]);
            if(heap.size()>k){
                // poll the min ele
                heap.poll();
            }
        }
        return heap.isEmpty()?-1:heap.poll();
    }
}
// @lc code=end

