/*
 * @Author: dingrui
 * @Date: 2021-07-08 13:26:21
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-08 13:28:52
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1450 lang=java
 *
 * [1450] 在既定时间做作业的学生人数
 */

// @lc code=start
class Solution {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int res = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (startTime[i] <= queryTime && queryTime <= endTime[i]) {
                res++;
            }
        }
        return res;
    }
}
// @lc code=end
