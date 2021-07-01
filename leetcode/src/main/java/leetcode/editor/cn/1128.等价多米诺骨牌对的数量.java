/*
 * @Author: dingrui
 * @Date: 2021-07-01 15:08:01
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-01 15:41:48
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1128 lang=java
 *
 * [1128] 等价多米诺骨牌对的数量
 */

// @lc code=start
class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int res = 0;
        int[] help = new int[100];
        for (int[] dominoe : dominoes) {
            int tenBaseVal = dominoe[0] <= dominoe[1] ? dominoe[0] * 10 + dominoe[1] : dominoe[1] * 10 + dominoe[0];
            res += help[tenBaseVal];
            help[tenBaseVal]++;
        }
        return res;
    }
}
// @lc code=end
