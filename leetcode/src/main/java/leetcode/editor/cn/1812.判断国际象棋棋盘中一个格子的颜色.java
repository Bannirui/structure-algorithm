/*
 * @Author: dingrui
 * @Date: 2021-07-12 17:52:55
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-12 17:55:57
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1812 lang=java
 *
 * [1812] 判断国际象棋棋盘中一个格子的颜色
 */

// @lc code=start
class Solution {
    public boolean squareIsWhite(String coordinates) {
        char c = coordinates.charAt(0);
        int n = coordinates.charAt(1) - '0';
        if ((c - 'a') % 2 == 0) {
            return n % 2 == 0;
        } else {
            return n % 2 != 0;
        }
    }
}
// @lc code=end
