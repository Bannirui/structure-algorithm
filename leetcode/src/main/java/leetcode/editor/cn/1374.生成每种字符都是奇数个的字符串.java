/*
 * @Author: dingrui
 * @Date: 2021-07-07 14:14:35
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-07 14:24:50
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1374 lang=java
 *
 * [1374] 生成每种字符都是奇数个的字符串
 */

// @lc code=start
class Solution {
    public String generateTheString(int n) {
        StringBuilder sb = new StringBuilder();
        if (n % 2 == 0) {
            // 偶数
            sb.append('a');
            for (int i = 0; i < n - 1; i++) {
                sb.append('b');
            }
        } else {
            // 奇数
            for (int i = 0; i < n; i++) {
                sb.append('a');
            }
        }
        return sb.toString();
    }
}
// @lc code=end
