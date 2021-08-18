/*
 * @Author: dingRui
 * @Date: 2021-08-18 16:31:05
 * @LastEditors: dingRui
 * @LastEditTime: 2021-08-18 17:42:27
 * @Description: 
 */
/*
 * @lc app=leetcode.cn id=390 lang=java
 *
 * [390] 消除游戏
 */

// @lc code=start
class Solution {
    public int lastRemaining(int n) {
        // 下标规律
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return 2 * (1 + n / 2) - 2 * this.lastRemaining(n / 2);
    }
}
// @lc code=end
