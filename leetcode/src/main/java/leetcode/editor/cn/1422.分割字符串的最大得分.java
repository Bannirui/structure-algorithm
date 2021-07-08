/*
 * @Author: dingrui
 * @Date: 2021-07-08 09:01:56
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-08 09:47:12
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1422 lang=java
 *
 * [1422] 分割字符串的最大得分
 */

// @lc code=start
class Solution {
    public int maxScore(String s) {
        // 1字符数量
        int oneBitCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                oneBitCount++;
            }
        }
        // 遍历
        int countZero = 0;
        int maxSum = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                // 0
                countZero++;
            } else {
                // 1
                oneBitCount--;
            }
            maxSum = Math.max((countZero + oneBitCount), maxSum);
        }
        return maxSum;
    }
}
// @lc code=end
