/*
 * @Author: dingrui
 * @Date: 2021-07-06 22:50:03
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-06 22:51:20
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1342 lang=java
 *
 * [1342] 将数字变成 0 的操作次数
 */

// @lc code=start
class Solution {
    public int numberOfSteps(int num) {
        int res = 0;
        while (num != 0) {
            if (num % 2 == 0) {
                // 偶数
                num >>= 1;
            } else {
                // 奇数
                num -= 1;
            }
            res++;
        }
        return res;
    }
}
// @lc code=end
