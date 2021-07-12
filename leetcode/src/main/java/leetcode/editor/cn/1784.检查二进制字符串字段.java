/*
 * @Author: dingrui
 * @Date: 2021-07-12 16:16:54
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-12 16:23:07
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1784 lang=java
 *
 * [1784] 检查二进制字符串字段
 */

// @lc code=start
class Solution {
    public boolean checkOnesSegment(String s) {
        return !s.contains("01");
    }
}
// @lc code=end
