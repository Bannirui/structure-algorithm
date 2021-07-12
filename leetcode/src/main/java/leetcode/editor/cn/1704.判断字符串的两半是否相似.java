/*
 * @Author: dingrui
 * @Date: 2021-07-12 11:03:16
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-12 11:10:20
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1704 lang=java
 *
 * [1704] 判断字符串的两半是否相似
 */

// @lc code=start
class Solution {
    public boolean halvesAreAlike(String s) {
        // 前半段 后半段 元音数量
        int pre = 0, post = 0;
        for (int i = 0; i < (s.length() >> 1); i++) {
            char preChar = s.charAt(i);
            char postChar = s.charAt(i + (s.length() >> 1));
            if (isAre(preChar)) {
                pre++;
            }
            if (isAre(postChar)) {
                post++;
            }
        }
        return pre == post;
    }

    private boolean isAre(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O'
                || c == 'U') {

            return true;
        }
        return false;
    }
}
// @lc code=end
