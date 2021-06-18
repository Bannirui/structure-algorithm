/*
 * @Author: dingrui
 * @Date: 2021-06-18 09:00:04
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-18 10:13:38
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=504 lang=java
 *
 * [504] 七进制数
 */

// @lc code=start
class Solution {
    public String convertToBase7(int num) {
        // 进制转换 7进制 正数 负数
        if (num < 0) {
            // 负数转正数处理
            return "-" + convertToBase7(-1 * num);
        }
        // 正数base case
        if (num < 7) {
            // 0<=num<7
            return "" + num;
        } else {
            // num>=7 递归
            return convertToBase7(num / 7) + convertToBase7(num % 7);
        }
    }
}
// @lc code=end
