/*
 * @Author: dingrui
 * @Date: 2021-07-08 15:45:48
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-08 15:53:28
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1523 lang=java
 *
 * [1523] 在区间范围内统计奇数数目
 */

// @lc code=start
class Solution {
    public int countOdds(int low, int high) {
        return this.count(high) - this.count(low - 1);
    }

    // 1...n 奇数的个数
    private int count(int n) {
        return (1 + n) >>> 1;
    }
}
// @lc code=end
