/*
 * @Author: dingrui
 * @Date: 2021-07-05 21:00:58
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-05 21:06:54
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1486 lang=java
 *
 * [1486] 数组异或操作
 */

// @lc code=start
class Solution {
    public int xorOperation(int n, int start) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            res ^= ((i << 1) + start);
        }
        return res;
    }
}
// @lc code=end
