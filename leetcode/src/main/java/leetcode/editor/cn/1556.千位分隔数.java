/*
 * @Author: dingrui
 * @Date: 2021-07-08 19:52:38
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-08 19:59:39
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1556 lang=java
 *
 * [1556] 千位分隔数
 */

// @lc code=start
class Solution {
    public String thousandSeparator(int n) {
        if (n == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (n != 0) {
            int left = n % 10;
            sb.append(left);
            count++;
            n /= 10;
            if (n != 0 && count % 3 == 0) {
                sb.append(".");
            }
        }
        return sb.reverse().toString();
    }
}
// @lc code=end
