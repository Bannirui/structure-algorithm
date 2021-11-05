/*
 * @lc app=leetcode.cn id=494 lang=java
 *
 * [494] 目标和
 */

// @lc code=start
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return this.trace(nums, 0, target, 0);
    }

    // 回溯
    private int trace(int[] nums, int idx, int target, int sum){
        // base case
        if(idx==nums.length){
            if(target==sum){
                return 1;
            }
            return 0;
        }
        // nums中遍历到idx 当前和为sum
        // 加上当前数字 减去当前数字
        return this.trace(nums, idx+1, target, sum+nums[idx])+this.trace(nums, idx+1, target, sum-nums[idx]);
    }
}
// @lc code=end

