/*
 * @Author: dingRui
 * @Date: 2021-08-09 10:49:08
 * @LastEditors: dingRui
 * @LastEditTime: 2021-08-09 11:06:38
 * @Description: 
 */
/*
 * @lc app=leetcode.cn id=319 lang=java
 *
 * [319] 灯泡开关
 */

// @lc code=start
class Solution {
    public int bulbSwitch(int n) {
        int res = 0;
        // [1...n]上 完全平方数的因子数是奇数个 非完全平方数的因子数是偶数个
        for (int i = 1; i * i <= n; i++) {
            res++;
        }
        return res;
    }
}
// @lc code=end
