import java.util.Scanner;

/*
 * @lc app=leetcode.cn id=125 lang=java
 *
 * [125] 验证回文串
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(String s) {
        // base case
        if (s == null) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        return this.dfs(s, 0, s.length() - 1);
    }

    // s[start...end]是否是回文
    private boolean dfs(String s, int start, int end) {
        // base case
        if (start >= end) {
            return true;
        }
        char startChar = s.charAt(start);
        char endChar = s.charAt(end);
        if (!Character.isLetterOrDigit(startChar)) {
            return this.dfs(s, start + 1, end);
        }
        if (!Character.isLetterOrDigit(endChar)) {
            return this.dfs(s, start, end - 1);
        }
        // 区分大小写
        boolean sameChar = false;
        if (Character.isDigit(startChar)) {
            // 数字
            if (Character.isDigit(endChar)) {
                // 数字
                sameChar = startChar == endChar;
            } else {
                // 字母
                sameChar = false;
            }
        } else {
            // 字母
            if (Character.isDigit(endChar)) {
                // 数字
                sameChar = false;
            } else {
                // 字母 大小写
                if (startChar == endChar || ((startChar - 'a') == (endChar - 'A'))
                        || ((startChar - 'A') == (endChar - 'a'))) {
                    sameChar = true;
                }
            }
        }
        return sameChar && this.dfs(s, start + 1, end - 1);
    }
}
// @lc code=end
