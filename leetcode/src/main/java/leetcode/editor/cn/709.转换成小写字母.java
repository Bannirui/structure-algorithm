/*
 * @Author: dingrui
 * @Date: 2021-06-25 13:47:08
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-25 13:52:48
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=709 lang=java
 *
 * [709] 转换成小写字母
 */

// @lc code=start
class Solution {
    public String toLowerCase(String s) {
        char[] sArr = s.toCharArray();
        for (int i = 0; i < sArr.length; i++) {
            char curChar = sArr[i];
            // A-Z
            int gapWithA = curChar - 'A';
            int gapWithZ = 'Z' - curChar;
            if (gapWithA >= 0 && gapWithZ >= 0) {
                sArr[i] = (char) ('a' + gapWithA);
            }
        }
        return new String(sArr);
    }
}
// @lc code=end
