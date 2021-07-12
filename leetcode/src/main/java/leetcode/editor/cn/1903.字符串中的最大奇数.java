/*
 * @Author: dingrui
 * @Date: 2021-07-12 22:21:37
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-12 22:25:37
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1903 lang=java
 *
 * [1903] 字符串中的最大奇数
 */

// @lc code=start
class Solution {
    public String largestOddNumber(String num) {
        for (int i = num.length() - 1; i >= 0; i--) {
            if ((num.charAt(i) - '0') % 2 != 0) {
                return num.substring(0, i + 1);
            }
        }
        return "";
    }
}
// @lc code=end
