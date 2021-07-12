/*
 * @Author: dingrui
 * @Date: 2021-07-12 21:08:36
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-12 21:18:51
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1869 lang=java
 *
 * [1869] 哪种连续子字符串更长
 */

// @lc code=start
class Solution {
    public boolean checkZeroOnes(String s) {
        int mx0 = 0;
        int mx1 = 0;
        char prev = '#'; // 上个字符
        int cnt = 0;
        for (char ch : s.toCharArray()) {
            // 当前字符与上个字符相等
            if (ch == prev) {
                ++cnt;
            } else {
                if (prev == '0') {
                    mx0 = Math.max(mx0, cnt);
                } else if (prev == '1') {
                    mx1 = Math.max(mx1, cnt);
                }
                cnt = 1;
            }
            prev = ch;
        }
        // 字符串结尾的连续子串
        if (prev == '0') {
            mx0 = Math.max(mx0, cnt);
        } else if (prev == '1') {
            mx1 = Math.max(mx1, cnt);
        }
        return mx1 > mx0;
    }
}
// @lc code=end
