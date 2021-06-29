import java.util.ArrayList;
import java.util.List;

/*
 * @Author: dingrui
 * @Date: 2021-06-29 09:23:10
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-29 09:27:05
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1480 lang=java
 *
 * [1480] 一维数组的动态和
 */

// @lc code=start
class Solution {
    public int[] runningSum(int[] nums) {
        int[] res = new int[nums.length];
        int curSum = 0;
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            res[i] = curSum;
        }
        return res;
    }
}
// @lc code=end
