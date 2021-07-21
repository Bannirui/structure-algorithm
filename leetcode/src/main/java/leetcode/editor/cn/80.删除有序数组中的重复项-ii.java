/*
 * @Author: dingrui
 * @Date: 2021-07-21 18:00:26
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-21 20:43:19
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=80 lang=java
 *
 * [80] 删除有序数组中的重复项 II
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        int j = 1;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                // 重复
                count++;
            } else {
                count = 1;
            }
            if (count <= 2) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}
// @lc code=end
