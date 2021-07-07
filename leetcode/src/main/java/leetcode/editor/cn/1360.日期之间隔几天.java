/*
 * @Author: dingrui
 * @Date: 2021-07-07 08:58:58
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-07 09:43:40
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1360 lang=java
 *
 * [1360] 日期之间隔几天
 */

// @lc code=start
class Solution {

    int[] daysOfMonth = new int[] { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    public int daysBetweenDates(String date1, String date2) {
        // yyyy-MM-dd
        int year1 = Integer.parseInt(date1.substring(0, 4));
        int year2 = Integer.parseInt(date2.substring(0, 4));
        int month1 = date1.charAt(5) == '0' ? (date1.charAt(6) - '0') : Integer.parseInt(date1.substring(5, 7));
        int month2 = date2.charAt(5) == '0' ? (date2.charAt(6) - '0') : Integer.parseInt(date2.substring(5, 7));
        int day1 = date1.charAt(8) == '0' ? (date1.charAt(9) - '0') : Integer.parseInt(date1.substring(8, 10));
        int day2 = date2.charAt(8) == '0' ? (date2.charAt(9) - '0') : Integer.parseInt(date2.substring(8, 10));
        // baseYear-01-01
        int baseYear = Math.min(year1, year2);
        int gap1 = this.daysGap(baseYear, year1, month1, day1);
        int gap2 = this.daysGap(baseYear, year2, month2, day2);
        return Math.abs(gap1 - gap2);
    }

    // 以baseYear-01-01为参考 aimYear-aimMonth-aimDay相距的天数
    private int daysGap(int baseYear, int aimYear, int aimMonth, int aimDay) {
        int days = 0;
        // year
        for (int year = baseYear; year < aimYear; year++) {
            days += 365;
            if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                days++;
            }
        }
        // month
        for (int month = 1; month < aimMonth; month++) {
            days += this.daysOfMonth[month];
        }
        if ((aimYear % 4 == 0 && aimYear % 100 != 0) || (aimYear % 400 == 0)) {
            if (aimMonth >= 3) {
                days++;
            }
        }
        // day
        for (int day = 1; day < aimDay; day++) {
            days++;
        }
        return days;
    }
}
// @lc code=end
