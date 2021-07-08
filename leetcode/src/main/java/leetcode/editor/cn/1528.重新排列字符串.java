/*
 * @Author: dingrui
 * @Date: 2021-07-08 15:54:32
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-08 16:00:04
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1528 lang=java
 *
 * [1528] 重新排列字符串
 */

// @lc code=start
class Solution {
    public String restoreString(String s, int[] indices) {
        char[] res = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            res[indices[i]] = s.charAt(i);
        }
        return new String(res);
    }
}
// @lc code=end
