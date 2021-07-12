/*
 * @Author: dingrui
 * @Date: 2021-07-12 16:46:39
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-12 17:21:45
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1800 lang=java
 *
 * [1800] 最大升序子数组和
 */

// @lc code=start
class Solution {
    public int maxAscendingSum(int[] nums) {
        int res = 0;
        // [start ... end]
        flag: for (int start = 0; start < nums.length;) {
            int sum = nums[start];
            for (int end = start + 1; end < nums.length; end++) {
                if (nums[end - 1] < nums[end]) {
                    sum += nums[end];
                } else {
                    // 出现了不连续递增
                    res = Math.max(res, sum);
                    start = end;
                    continue flag;
                }
            }
            start++;
            res = Math.max(res, sum);
        }
        return res;
    }
}
// @lc code=end
