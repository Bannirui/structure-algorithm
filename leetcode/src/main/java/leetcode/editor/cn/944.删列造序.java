/*
 * @Author: dingrui
 * @Date: 2021-06-29 15:37:09
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-29 15:50:28
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=944 lang=java
 *
 * [944] 删列造序
 */

// @lc code=start
class Solution {
    public int minDeletionSize(String[] strs) {
        int res = 0;
        int cols = strs[0].length();
        for (int col = 0; col < cols; col++) {
            // 每个字符串的字符比较
            // 表示当前列是否已经寻找过
            boolean find = false;
            if (!find) {
                for (int row = 0; row < strs.length - 1; row++) {
                    if (strs[row].charAt(col) > strs[row + 1].charAt(col)) {
                        res++;
                        find = true;
                        break;
                    }
                }
            }
        }
        return res;
    }
}
// @lc code=end
