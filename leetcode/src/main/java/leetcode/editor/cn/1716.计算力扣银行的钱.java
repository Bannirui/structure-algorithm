/*
 * @Author: dingrui
 * @Date: 2021-07-12 13:11:23
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-12 13:36:21
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1716 lang=java
 *
 * [1716] 计算力扣银行的钱
 */

// @lc code=start
class Solution {
    public int totalMoney(int n) {
        // 第几个星期一 第几轮
        int loop = n / 7;
        // 每一轮的第几天
        int day = n % 7;
        // 第一轮总和
        int base = 28;
        return (28 * loop) + (7 * loop * (loop - 1) / 2) + (loop * day) + (day*(day+1)/2);
    }
}
// @lc code=end
