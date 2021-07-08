/*
 * @Author: dingrui
 * @Date: 2021-07-08 10:46:21
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-08 10:57:38
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1446 lang=java
 *
 * [1446] 连续字符
 */

// @lc code=start
class Solution {
    public int maxPower(String s) {
        int maxLen = 0;
        int lastIndex = 0;
        int curLen = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(lastIndex)) {
                curLen++;
            } else {
                lastIndex = i;
                curLen = 1;
            }
            maxLen = Math.max(maxLen, curLen);
        }
        return Math.max(maxLen, curLen);
    }
}
// @lc code=end
