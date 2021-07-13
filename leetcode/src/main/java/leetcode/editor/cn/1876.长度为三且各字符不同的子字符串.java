/*
 * @Author: dingrui
 * @Date: 2021-07-13 09:28:26
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-13 09:37:12
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1876 lang=java
 *
 * [1876] 长度为三且各字符不同的子字符串
 */

// @lc code=start
class Solution {
    public int countGoodSubstrings(String s) {
        // 窗口=3后移
        int res = 0;
        for (int i = 0; i < s.length() - 2; i++) {
            if (this.isGoodStr(s.substring(i, i + 3))) {
                res++;
            }
        }
        return res;
    }

    private boolean isGoodStr(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 1) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end
