import java.util.Arrays;

/*
 * @Author: dingrui
 * @Date: 2021-06-18 21:34:41
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-21 13:19:47
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=561 lang=java
 *
 * [561] 数组拆分 I
 */

// @lc code=start
class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length; i += 2) {
            res += nums[i];
        }
        return res;
    }
}
// @lc code=end
