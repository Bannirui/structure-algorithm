/*
 * @Author: dingrui
 * @Date: 2021-06-29 13:49:46
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-29 14:16:10
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=925 lang=java
 *
 * [925] 长按键入
 */

// @lc code=start
class Solution {
    public boolean isLongPressedName(String name, String typed) {
        // 在typed中一定存在name 相对顺序
        int i = 0, j = 0;
        while (j < typed.length()) {
            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                // 两个字符相等
                i++;
                j++;
            } else {
                // typed的当前字符根自己的上一个字符是不是相等
                if (j >= 1 && (typed.charAt(j - 1) == typed.charAt(j))) {
                    j++;
                } else {
                    return false;
                }
            }
        }
        return i == name.length();
    }
}
// @lc code=end
