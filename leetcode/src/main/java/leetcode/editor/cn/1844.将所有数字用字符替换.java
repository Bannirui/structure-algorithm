/*
 * @Author: dingrui
 * @Date: 2021-07-12 20:23:56
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-12 20:35:09
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1844 lang=java
 *
 * [1844] 将所有数字用字符替换
 */

// @lc code=start
class Solution {
    public String replaceDigits(String s) {
        char[] sArr = s.toCharArray();
        for (int i = 0; i < s.length();) {
            if (i % 2 == 0) {
                i++;
            } else {
                // 奇数
                sArr[i] = (char) (sArr[i - 1] + (int) (sArr[i] - '0'));
                i += 2;
            }
        }
        return new String(sArr);
    }
}
// @lc code=end
