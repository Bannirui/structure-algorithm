/*
 * @Author: dingrui
 * @Date: 2021-07-12 18:15:56
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-12 18:16:30
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1837 lang=java
 *
 * [1837] K 进制表示下的各位数字总和
 */

// @lc code=start
class Solution {
    public int sumBase(int n, int k) {
        int res = 0;
        while (n != 0) {
            res += (n % k);
            n /= k;
        }
        return res;
    }
}
// @lc code=end
