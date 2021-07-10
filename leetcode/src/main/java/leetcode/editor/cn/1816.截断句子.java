/*
 * @Author: dingrui
 * @Date: 2021-07-10 19:07:33
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-10 19:09:54
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1816 lang=java
 *
 * [1816] 截断句子
 */

// @lc code=start
class Solution {
    public String truncateSentence(String s, int k) {
        StringBuilder sb = new StringBuilder();
        String[] words = s.split("\\s+");
        for (int i = 0; i < k; i++) {
            sb.append(words[i]);
            if (i != k - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
// @lc code=end
