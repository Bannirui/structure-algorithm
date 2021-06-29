/*
 * @Author: dingrui
 * @Date: 2021-06-29 09:08:46
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-29 09:16:48
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=905 lang=java
 *
 * [905] 按奇偶排序数组
 */

// @lc code=start
class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int[] res = new int[nums.length];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                // 偶数
                res[index] = nums[i];
                index++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 != 0) {
                // 奇数
                res[index] = nums[i];
                index++;
            }
        }
        return res;
    }
}
// @lc code=end
