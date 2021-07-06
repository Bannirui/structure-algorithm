/*
 * @Author: dingrui
 * @Date: 2021-07-06 17:32:43
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-06 18:55:47
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1332 lang=java
 *
 * [1332] 删除回文子序列
 */

// @lc code=start
class Solution {
    public int removePalindromeSub(String s) {
        // 空串
        if (s.length() == 0) {
            return 0;
        }
        // 本身已经回文
        if (this.isPalindrome(s, 0, s.length() - 1)) {
            return 1;
        }
        return 2;
    }

    // s是否是回文串 true:s是回文串 false:s不是回文串
    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
// @lc code=end
