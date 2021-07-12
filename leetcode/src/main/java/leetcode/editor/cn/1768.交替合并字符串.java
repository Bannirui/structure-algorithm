/*
 * @Author: dingrui
 * @Date: 2021-07-12 15:52:27
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-12 16:01:20
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1768 lang=java
 *
 * [1768] 交替合并字符串
 */

// @lc code=start
class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < word1.length() && i < word2.length()) {
            // 先word1 后word2
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
            i++;
        }
        if (i < word1.length()) {
            sb.append(word1.substring(i, word1.length()));
        }
        if (i < word2.length()) {
            sb.append(word2.substring(i, word2.length()));
        }
        return sb.toString();
    }
}
// @lc code=end
