/*
 * @Author: dingrui
 * @Date: 2021-07-03 14:35:57
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-03 14:43:21
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1189 lang=java
 *
 * [1189] “气球” 的最大数量
 */

// @lc code=start
class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] help = new int[26];
        for (int i = 0; i < text.length(); i++) {
            help[text.charAt(i) - 'a']++;
        }
        // balloon
        help['l' - 'a'] >>= 1;
        help['o' - 'a'] >>= 1;
        // min
        String aim = "balloon";
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < aim.length(); i++) {
            res = Math.min(res, help[aim.charAt(i) - 'a']);
        }
        return res;
    }
}
// @lc code=end
