import java.sql.Date;
import java.time.LocalDate;

/*
 * @Author: dingrui
 * @Date: 2021-07-03 11:16:41
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-03 15:33:53
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1185 lang=java
 *
 * [1185] 一周中的第几天
 */

// @lc code=start
class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        int daysSum = 0;
        // year
        for (int y = 1971; y < year; y++) {
            daysSum += 365;
            if ((y % 4 == 0 && y % 100 != 0) || y % 400 == 0) {
                daysSum++;
            }
        }
        // month
        int[] daysOfMonth = new int[] { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        for (int m = 1; m < month; m++) {
            daysSum += daysOfMonth[m];
        }
        if (month > 2) {
            if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                daysSum++;
            }
        }
        // day
        daysSum += day - 1;
        String[] week = new String[] { "Friday", "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday" };
        return week[daysSum % 7];
    }
}
// @lc code=end
