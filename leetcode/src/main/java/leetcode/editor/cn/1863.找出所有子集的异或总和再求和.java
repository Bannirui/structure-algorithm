/*
 * @Author: dingrui
 * @Date: 2021-07-12 21:01:48
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-13 09:26:49
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1863 lang=java
 *
 * [1863] 找出所有子集的异或总和再求和
 */

// @lc code=start
class Solution {

    private int res;

    public int subsetXORSum(int[] nums) {
        // 递归
        this.res = 0;
        dfs(0, nums.length, 0, nums);
        return this.res;
    }

    // index:当前的脚标
    // end:脚标截止
    // path:该策略下的异或和
    private void dfs(int index, int end, int path, int[] nums) {
        // base case
        if (index == end) {
            // 收集当前策略下的结果
            this.res += path;
            return;
        }
        // 要当前数字
        dfs(index + 1, end, path ^ nums[index], nums);
        // 不要当前数字
        dfs(index + 1, end, path, nums);
    }
}
// @lc code=end
