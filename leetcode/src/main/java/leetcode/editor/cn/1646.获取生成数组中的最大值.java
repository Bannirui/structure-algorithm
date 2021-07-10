/*
 * @Author: dingrui
 * @Date: 2021-07-10 16:55:12
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-10 16:59:54
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1646 lang=java
 *
 * [1646] 获取生成数组中的最大值
 */

// @lc code=start
class Solution {
    public int getMaximumGenerated(int n) {
        // base case
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int res = Integer.MIN_VALUE;
        int[] helpArr = new int[n + 1];
        helpArr[0] = 0;
        helpArr[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                helpArr[i] = helpArr[i / 2];
            } else {
                helpArr[i] = helpArr[i / 2] + helpArr[i / 2 + 1];
            }
            res = Math.max(helpArr[i], res);
        }
        return res;
    }
}
// @lc code=end
