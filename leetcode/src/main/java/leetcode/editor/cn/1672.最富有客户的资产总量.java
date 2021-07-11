/*
 * @Author: dingrui
 * @Date: 2021-07-11 16:28:10
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-11 16:31:23
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1672 lang=java
 *
 * [1672] 最富有客户的资产总量
 */

// @lc code=start
class Solution {
    public int maximumWealth(int[][] accounts) {
        int res = 0;
        for (int[] account : accounts) {
            int sum = 0;
            for (int num : account) {
                sum += num;
            }
            res = Math.max(res, sum);
        }
        return res;
    }
}
// @lc code=end
