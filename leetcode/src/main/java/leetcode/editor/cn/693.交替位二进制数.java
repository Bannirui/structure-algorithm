/*
 * @Author: dingrui
 * @Date: 2021-06-22 19:11:39
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-23 09:23:48
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=693 lang=java
 *
 * [693] 交替位二进制数
 */

// @lc code=start
class Solution {
    public boolean hasAlternatingBits(int n) {
        // 0跟1交替出现
        // 获得所有二进制都是1的数字
        int tmp = n ^ (n >> 1);
        // 判断是否都是1
        while (tmp != 0) {
            if ((tmp & 1) == 0) {
                // 进制位上出现了0
                return false;
            }
            tmp >>= 1;
        }
        return true;
    }
}
// @lc code=end
