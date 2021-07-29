/*
 * @Author: dingrui
 * @Date: 2021-07-29 11:50:12
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-29 13:21:20
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=201 lang=java
 *
 * [201] 数字范围按位与
 */

// @lc code=start
class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int shift = 0;
        while (left != right) {
            left >>= 1;
            right >>= 1;
            shift++;
        }
        return left << shift;
    }
}
// @lc code=end
