/*
 * @Author: dingrui
 * @Date: 2021-06-18 11:07:37
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-21 10:33:46
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=541 lang=java
 *
 * [541] 反转字符串 II
 */

// @lc code=start
class Solution {
    public String reverseStr(String s, int k) {
        // 前2k个一组
        int len = s.length();
        char[] cArray = s.toCharArray();
        for (int i = 0; i < len; i += 2 * k) {
            // 每个分组里面前k个进行翻转
            int start = i, end = Math.min(start + k - 1, len - 1);
            while (start < end) {
                char tmp = cArray[start];
                cArray[start] = cArray[end];
                cArray[end] = tmp;
                start++;
                end--;
            }
        }
        return new String(cArray);
    }
}
// @lc code=end
