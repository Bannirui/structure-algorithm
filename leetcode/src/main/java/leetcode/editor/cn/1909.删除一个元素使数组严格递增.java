/*
 * @Author: dingrui
 * @Date: 2021-07-12 21:50:56
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-13 10:25:23
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1909 lang=java
 *
 * [1909] 删除一个元素使数组严格递增
 */

// @lc code=start
class Solution {
    public boolean canBeIncreasing(int[] nums) {
        // 原序列中之多只有一个非递增的点 记录第一个非递增的脚标
        int count = 0;
        int firstDescIndex = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                if (firstDescIndex == -1) {
                    firstDescIndex = i;
                }
                count++;
            }
        }
        if (count == 0) {
            return true;
        }
        if (count > 1) {
            return false;
        }
        // 移除非递增 是否能达到严格递增 [i-1, i]
        // 移除i-1 [i-2,i]递增
        // 移除i [i-1，i+1]递增
        boolean option1 = true;
        boolean option2 = true;
        if ((firstDescIndex - 2) >= 0) {
            if (nums[firstDescIndex] <= nums[firstDescIndex - 2]) {
                option1 = false;
            }
        }
        if ((firstDescIndex - 1) >= 0 && (firstDescIndex + 1) < nums.length) {
            if (nums[firstDescIndex + 1] <= nums[firstDescIndex - 1]) {
                option2 = false;
            }
        }
        return option1 || option2;
    }
}
// @lc code=end
