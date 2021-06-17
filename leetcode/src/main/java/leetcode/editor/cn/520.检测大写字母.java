/*
 * @lc app=leetcode.cn id=520 lang=java
 *
 * [520] 检测大写字母
 */

// @lc code=start
class Solution {
    public boolean detectCapitalUse(String word) {
        // base case
        int len = word.length();
        if (len == 0 || len == 1) {
            return true;
        }
        int upperCount = 0;
        for (int i = 0; i < len; i++) {
            char c = word.charAt(i);
            if ('A' <= c && c <= 'Z') {
                upperCount++;
            }
        }
        if (upperCount == len || upperCount == 0) {
            return true;
        }
        if (upperCount == 1 && ('A' <= word.charAt(0) && word.charAt(0) <= 'Z')) {
            return true;
        }
        return false;
    }
}
// @lc code=end
