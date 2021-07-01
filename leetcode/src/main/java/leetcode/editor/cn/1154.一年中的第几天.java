/*
 * @Author: dingrui
 * @Date: 2021-07-01 17:07:41
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-01 17:25:20
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1154 lang=java
 *
 * [1154] 一年中的第几天
 */

// @lc code=start
class Solution {
    public int dayOfYear(String date) {
        // 闰2月=29天 闰年=能被4整除不能被100整除
        int[] daysOfMonth = new int[] { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int res = 0;
        int year = Integer.valueOf(date.substring(0, 4));
        int month = date.charAt(5) == '0' ? date.charAt(6) - '0' : Integer.valueOf(date.substring(5, 7));
        int day = date.charAt(8) == '0' ? date.charAt(9) - '0' : Integer.valueOf(date.substring(8, 10));
        // 天
        res += day;
        // 月
        for (int m = 1; m < month; m++) {
            res += daysOfMonth[m];
        }
        // 年 闰年
        if (year % 4 == 0 && year % 100 != 0 && month > 2) {
            res++;
        }
        if (year % 400 == 0 && month > 2) {
            res++;
        }
        return res;
    }
}
// @lc code=end
