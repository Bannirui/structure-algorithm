/*
 * @Author: dingrui
 * @Date: 2021-07-12 14:58:12
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-12 15:48:48
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1758 lang=java
 *
 * [1758] 生成交替二进制字符串的最少操作数
 */

// @lc code=start
class Solution {
    public int minOperations(String s) {
        return Math.min(minOperate(s, '0', 0, s.length(), 0), minOperate(s, '1', 0, s.length(), 0));
    }

    // 将s变成c开头的交替字符串最少步骤
    private int minOperate(String s, char c, int start, int end, int count) {
        // base case
        if (start >= s.length()) {
            return count;
        }
        if (s.charAt(start) == c) {
            // 当前不需要变
        } else {
            // 当前需要变
            count++;
        }
        char next = c == '0' ? '1' : '0';
        return minOperate(s, next, start + 1, end, count);
    }
}
// @lc code=end
