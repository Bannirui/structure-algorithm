/*
 * @Author: dingrui
 * @Date: 2021-07-22 23:24:30
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-22 23:31:52
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=494 lang=java
 *
 * [494] 目标和
 */

// @lc code=start
class Solution {

    private int[] nums;

    private int target;

    private int res = 0;

    public int findTargetSumWays(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        this.nums = nums;
        this.target = target;
        this.dfs(0, 0);
        return this.res;
    }

    // nums数组中 [0...index-1]已经处理结果是path
    // 处理[index...]
    private void dfs(int index, int path) {
        // base index
        if (index == this.nums.length) {
            if (path == target) {
                // 收集结果
                this.res++;
            }
            return;
        }
        // 当前数字前放 +或者-
        dfs(index + 1, path + this.nums[index]);
        dfs(index + 1, path - this.nums[index]);
    }
}
// @lc code=end
