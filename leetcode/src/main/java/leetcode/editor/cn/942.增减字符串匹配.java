/*
 * @Author: dingrui
 * @Date: 2021-06-29 16:46:58
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-29 17:12:37
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=942 lang=java
 *
 * [942] 增减字符串匹配
 */

// @lc code=start
class Solution {
    public int[] diStringMatch(String s) {
        int len = s.length();
        int min = 0, max = len;
        int[] res = new int[len + 1];
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == 'I') {
                res[i] = min;
                min++;
            }
            if (c == 'D') {
                res[i] = max;
                max--;
            }
        }
        res[len] = max;
        return res;
    }
}
// @lc code=end
