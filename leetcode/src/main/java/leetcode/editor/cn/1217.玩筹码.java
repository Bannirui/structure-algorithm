/*
 * @Author: dingrui
 * @Date: 2021-07-03 15:10:55
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-03 15:16:04
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1217 lang=java
 *
 * [1217] 玩筹码
 */

// @lc code=start
class Solution {
    public int minCostToMoveChips(int[] position) {
        int count1 = 0, count2 = 0;
        for (int i = 0; i < position.length; i++) {
            if (position[i] % 2 == 0) {
                count1++;
            } else {
                count2++;
            }
        }
        return Math.min(count1, count2);
    }
}
// @lc code=end
