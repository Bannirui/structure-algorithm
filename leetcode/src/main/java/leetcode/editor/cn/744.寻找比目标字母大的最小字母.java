/*
 * @Author: dingrui
 * @Date: 2021-06-28 13:59:44
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-28 14:34:26
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=744 lang=java
 *
 * [744] 寻找比目标字母大的最小字母
 */

// @lc code=start
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        // 二分
        int left = 0, right = letters.length - 1;
        char lastChar = letters[0];
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            char curChar = letters[mid];
            if (curChar > target) {
                // 记下当前 继续向左找
                lastChar = curChar;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return lastChar;
    }

}
// @lc code=end
