/*
 * @Author: dingrui
 * @Date: 2021-06-25 17:08:35
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-25 17:16:45
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=917 lang=java
 *
 * [917] 仅仅反转字母
 */

// @lc code=start
class Solution {
    public String reverseOnlyLetters(String s) {
        int l = 0, r = s.length() - 1;
        char[] sArr = s.toCharArray();
        while (l <= r) {
            char curLeftChar = sArr[l];
            char curRightChar = sArr[r];
            if (isLetter(curLeftChar)) {
                if (isLetter(curRightChar)) {
                    // l是字母 r是字母 交换
                    sArr[l] = curRightChar;
                    sArr[r] = curLeftChar;
                    l++;
                    r--;
                } else {
                    // l是字母 r不是字母
                    r--;
                }
            } else {
                if (isLetter(curRightChar)) {
                    // l不是字母 r是字母
                    l++;
                } else {
                    // l不是字母 r不是字母
                    l++;
                    r--;
                }
            }
        }
        return new String(sArr);
    }

    private boolean isLetter(char c) {
        if ((c - 'a' >= 0 && 'z' - c >= 0) || (c - 'A' >= 0 && 'Z' - c >= 0)) {
            return true;
        }
        return false;
    }
}
// @lc code=end
