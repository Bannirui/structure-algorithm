/*
 * @Author: dingrui
 * @Date: 2021-07-09 13:15:03
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-09 13:31:12
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1576 lang=java
 *
 * [1576] 替换所有的问号
 */

// @lc code=start
class Solution {
    public String modifyString(String s) {
        char[] res = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            // 遇到?进行字符替换
            if (s.charAt(i) == '?') {
                // 前一个字符
                char pre = (i == 0) ? ' ' : res[i - 1];
                // 后一个字符
                char next = (i == s.length() - 1) ? ' ' : res[i + 1];
                char cur = 'a';
                // 跟前后都不一样
                while (cur == pre || cur == next) {
                    cur++;
                }
                res[i] = cur;
            }
        }
        return new String(res);
    }
}
// @lc code=end
