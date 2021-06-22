/*
 * @Author: dingrui
 * @Date: 2021-06-22 17:26:35
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-22 19:10:22
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=680 lang=java
 *
 * [680] 验证回文字符串 Ⅱ
 */

// @lc code=start
class Solution {
    public boolean validPalindrome(String s) {
        // 可以不删除字符 可以删除1个字符
        int L = 0, R = s.length() - 1;
        while (L < R) {
            if (s.charAt(L) == s.charAt(R)) {
                L++;
                R--;
            } else {
                // 出现了需要删除的字符 L!=R 可能需要删除L也可能需要删除R
                return validPalindrome(s, L + 1, R) || validPalindrome(s, L, R - 1);
            }
        }
        return true;
    }

    /**
     * @author: dingrui
     * @Date: 2021-06-22 19:03:05
     * @param {*}
     * @return {*}
     * @description: 验证字符串s从start到end位置是否回文
     * @example: 
     */
    public boolean validPalindrome(String s, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end
