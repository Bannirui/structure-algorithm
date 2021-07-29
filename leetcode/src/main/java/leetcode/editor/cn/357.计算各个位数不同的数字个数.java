/*
 * @Author: dingrui
 * @Date: 2021-07-26 07:26:25
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-29 23:51:51
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=357 lang=java
 *
 * [357] 计算各个位数不同的数字个数
 */

// @lc code=start
class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        int f = 10;
        int s = 81;
        for (int i = 2; i <= n; i++) {
            f += s;
            s *= (10 - i);
        }
        return f;
    }
}
// @lc code=end
