/*
 * @Author: dingrui
 * @Date: 2021-06-21 14:26:05
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-21 14:35:24
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=674 lang=java
 *
 * [674] 最长连续递增序列
 */

// @lc code=start
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        // base case
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 遍历过程中指针维护状态
        int lastStartIndex = 0;
        int lastMaxLen = 1;
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            // 是否连续递增
            if (nums[i] > nums[i - 1]) {
                // 连续递增 更新最长连续递增子序列长度
                lastMaxLen = i - lastStartIndex + 1;
            } else {
                // 不连续递增 重置lastStartIndex
                lastStartIndex = i;
                res = Math.max(res, lastMaxLen);
                lastMaxLen = 1;
            }
        }
        return Math.max(lastMaxLen, res);
    }
}
// @lc code=end
