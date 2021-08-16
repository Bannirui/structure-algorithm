/*
 * @Author: dingRui
 * @Date: 2021-08-16 11:16:41
 * @LastEditors: dingRui
 * @LastEditTime: 2021-08-16 13:22:30
 * @Description: 
 */
/*
 * @lc app=leetcode.cn id=376 lang=java
 *
 * [376] 摆动序列
 */

// @lc code=start
class Solution {
    public int wiggleMaxLength(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return len;
        }
        int[] up = new int[len];
        int[] down = new int[len];
        // base case
        up[0] = 1;
        down[0] = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i - 1]) {
                up[i] = Math.max(up[i - 1], down[i - 1] + 1);
                down[i] = down[i - 1];
            } else if (nums[i] < nums[i - 1]) {
                up[i] = up[i - 1];
                down[i] = Math.max(up[i - 1] + 1, down[i - 1]);
            } else {
                up[i] = up[i - 1];
                down[i] = down[i - 1];
            }
        }
        return Math.max(up[len - 1], down[len - 1]);
    }
}
// @lc code=end
