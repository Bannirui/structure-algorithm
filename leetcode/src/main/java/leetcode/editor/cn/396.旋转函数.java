/*
 * @Author: dingRui
 * @Date: 2021-08-24 21:32:35
 * @LastEditors: dingRui
 * @LastEditTime: 2021-08-25 11:48:19
 * @Description: 
 */
/*
 * @lc app=leetcode.cn id=396 lang=java
 *
 * [396] 旋转函数
 */

// @lc code=start
class Solution {
    public int maxRotateFunction(int[] nums) {
        int sum = 0;
        int cur = 0;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            cur += j * nums[j];
        }
        // 翻转
        int res = cur;
        for (int i = nums.length - 1; i >= 0; i--) {
            // F(K+1) = F(K) + sum - n*Bk[n-1]
            cur += (sum - nums.length * nums[i]);
            res = Math.max(res, cur);
        }
        return res;
    }
}
// @lc code=end
