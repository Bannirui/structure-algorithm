/*
 * @Author: dingrui
 * @Date: 2021-07-12 15:24:15
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-12 15:33:59
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1763 lang=java
 *
 * [1763] 最长的美好子字符串
 */

// @lc code=start
class Solution {
    public String longestNiceSubstring(String s) {
        // 暴力
        String res = "";
        // [i...j]
        for (int i = 0; i < s.length(); i++) {
            endIndex: for (int j = i + 1; j < s.length(); j++) {
                String sub = s.substring(i, j + 1);
                if (sub.length() > res.length()) {
                    // sub是美好子串
                    for (char c : sub.toCharArray()) {
                        if (sub.indexOf(Character.toLowerCase(c)) < 0 || sub.indexOf(Character.toUpperCase(c)) < 0) {
                            continue endIndex;
                        }
                    }
                    res = sub;
                }
            }
        }
        return res;
    }
}
// @lc code=end
