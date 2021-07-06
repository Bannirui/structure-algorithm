/*
 * @Author: dingrui
 * @Date: 2021-07-06 16:08:14
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-06 16:31:58
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1309 lang=java
 *
 * [1309] 解码字母到整数映射
 */

// @lc code=start
class Solution {
    public String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (; i < s.length();) {
            // 当前字符
            char curChar = s.charAt(i);
            // 3-9 单个字符
            if (curChar - '3' >= 0 && '9' - curChar >= 0) {
                // 数字转字母
                char c = (char) (curChar - '1' + 'a');
                sb.append(c);
                i++;
            }
            // 1或者2
            if (curChar == '1' || curChar == '2') {
                if (i + 2 < s.length() && s.charAt(i + 2) == '#') {
                    // 3个字符组成xx#
                    int num = ((s.charAt(i) - '0') * 10) + (s.charAt(i + 1) - '0');
                    char c = (char) ((num - 1) + 'a');
                    sb.append(c);
                    i += 3;
                } else {
                    // 单个字符
                    char c = (char) (curChar - '1' + 'a');
                    sb.append(c);
                    i++;
                }
            }
        }
        return sb.toString();
    }
}
// @lc code=end
