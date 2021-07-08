/*
 * @Author: dingrui
 * @Date: 2021-07-08 14:47:47
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-08 14:52:19
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1491 lang=java
 *
 * [1491] 去掉最低工资和最高工资后的工资平均值
 */

// @lc code=start
class Solution {
    public double average(int[] salary) {
        int maxSalary = Integer.MIN_VALUE;
        int minSalary = Integer.MAX_VALUE;
        int sumSalary = 0;
        for (int i = 0; i < salary.length; i++) {
            maxSalary = Math.max(maxSalary, salary[i]);
            minSalary = Math.min(minSalary, salary[i]);
            sumSalary += salary[i];
        }
        return (double) (sumSalary - maxSalary - minSalary) / (salary.length - 2);
    }
}
// @lc code=end
