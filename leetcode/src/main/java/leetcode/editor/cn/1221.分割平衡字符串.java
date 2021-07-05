/*
 * @Author: dingrui
 * @Date: 2021-07-05 09:08:09
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-05 09:16:39
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1221 lang=java
 *
 * [1221] 分割平衡字符串
 */

// @lc code=start
class Solution {
    public int balancedStringSplit(String s) {
        int res = 0, tmp = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                tmp++;
            } else {
                tmp--;
            }
            if (tmp == 0) {
                res++;
            }
        }
        return res;
    }
}
// @lc code=end
