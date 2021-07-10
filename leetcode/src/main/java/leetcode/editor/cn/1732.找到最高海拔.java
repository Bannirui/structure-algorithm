/*
 * @Author: dingrui
 * @Date: 2021-07-10 18:50:09
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-10 18:51:22
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1732 lang=java
 *
 * [1732] 找到最高海拔
 */

// @lc code=start
class Solution {
    public int largestAltitude(int[] gain) {
        int max = 0;
        int sum = 0;
        for (int i = 0; i < gain.length; i++) {
            sum += gain[i];
            max = Math.max(max, sum);
        }
        return max;
    }
}
// @lc code=end
