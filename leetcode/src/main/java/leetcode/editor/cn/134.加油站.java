/*
 * @Author: dingrui
 * @Date: 2021-07-26 11:11:46
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-26 13:37:04
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=134 lang=java
 *
 * [134] 加油站
 */

// @lc code=start
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // 遍历所有汽油站 作为出发点 是否能够回到自己
        int counts = gas.length;
        for (int i = 0; i < counts; i++) {
            // 能够回到自己的标准
            int j = i;
            int remain = gas[i];
            while (remain - cost[j] >= 0) {
                remain += (-cost[j] + gas[(j + 1) % counts]);
                j = (j + 1) % counts;
                if (j == i) {
                    return i;
                }
            }
        }
        return -1;
    }
}
// @lc code=end
