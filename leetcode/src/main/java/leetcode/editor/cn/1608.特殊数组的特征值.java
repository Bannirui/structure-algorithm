/*
 * @Author: dingrui
 * @Date: 2021-07-10 14:24:18
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-10 14:43:53
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1608 lang=java
 *
 * [1608] 特殊数组的特征值
 */

// @lc code=start
class Solution {
    public int specialArray(int[] nums) {
        // res区间[1...nums.length]
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int[] numCounts = new int[max + 1];
        // num出现的次数
        for (int num : nums) {
            numCounts[num]++;
        }
        int curCounts = 0;
        for (int res = max; res > 0; res--) {
            curCounts += numCounts[res];
            if (curCounts == res) {
                return res;
            }
        }
        return -1;
    }
}
// @lc code=end
