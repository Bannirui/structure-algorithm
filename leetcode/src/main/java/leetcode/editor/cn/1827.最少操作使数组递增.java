import javax.swing.Renderer;

/*
 * @Author: dingrui
 * @Date: 2021-07-12 18:05:45
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-12 18:12:24
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1827 lang=java
 *
 * [1827] 最少操作使数组递增
 */

// @lc code=start
class Solution {
    public int minOperations(int[] nums) {
        int[] resNums = new int[nums.length];
        resNums[0] = nums[0];
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            if (resNums[i - 1] >= nums[i]) {
                // 出现非递增
                resNums[i] = Math.max(resNums[i - 1] + 1, nums[i]);
            } else {
                // 递增
                resNums[i] = nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            res += (resNums[i] - nums[i]);
        }
        return res;
    }
}
// @lc code=end
