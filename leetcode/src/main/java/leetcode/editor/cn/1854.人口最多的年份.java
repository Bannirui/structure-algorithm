/*
 * @Author: dingrui
 * @Date: 2021-07-12 20:18:47
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-12 20:22:41
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1854 lang=java
 *
 * [1854] 人口最多的年份
 */

// @lc code=start
class Solution {
    public int maximumPopulation(int[][] logs) {
        // [1950, 2050]
        int[] yearCount = new int[101];
        for (int[] log : logs) {
            for (int year = log[0]; year < log[1]; year++) {
                yearCount[year - 1950]++;
            }
        }
        int res = 0;
        int maxCount = Integer.MIN_VALUE;
        for (int i = 0; i < 101; i++) {
            if (yearCount[i] > maxCount) {
                res = i;
                maxCount = yearCount[i];
            }
        }
        return res + 1950;
    }
}
// @lc code=end
