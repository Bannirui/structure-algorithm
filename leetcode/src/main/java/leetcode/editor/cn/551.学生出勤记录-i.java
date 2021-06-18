/*
 * @Author: dingrui
 * @Date: 2021-06-18 10:19:08
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-18 10:30:20
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=551 lang=java
 *
 * [551] 学生出勤记录 I
 */

// @lc code=start
class Solution {
    public boolean checkRecord(String s) {
        // 遍历过程中 记录A的数量 L的数量以及上一次最后一个L的下标
        int countA = 0, countL = 0, lastLIndex = -1;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            // A
            if ('A' == s.charAt(i)) {
                countA++;
            }
            // L
            if ('L' == s.charAt(i)) {
                if (i == (lastLIndex + 1)) {
                    // 连续的L
                    countL++;
                    lastLIndex = i;
                } else {
                    countL = 1;
                    lastLIndex = i;
                }
            }
            if (countA > 1 || countL > 2) {
                return false;
            }
        }
        // 遍历过程中没有因为2个A或者连续3个L退出
        return true;
    }
}
// @lc code=end
