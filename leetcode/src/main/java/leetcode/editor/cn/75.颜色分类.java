/*
 * @Author: dingrui
 * @Date: 2021-07-14 10:25:05
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-14 10:38:49
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=75 lang=java
 *
 * [75] 颜色分类
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        // <1->左边 =1->中间 >1->右边
        int left = -1, right = nums.length;
        flag: for (int i = 0; i < nums.length; i++) {
            while (i > left & i < right) {
                if (nums[i] < 1) {
                    // 左边界右移 放到左边
                    left++;
                    this.swap(nums, i, left);
                }
                if (nums[i] == 1) {
                    // 啥都不用做
                    continue flag;
                }
                if (nums[i] > 1) {
                    // 右边界左移 放到右边
                    right--;
                    this.swap(nums, i, right);
                }
            }
        }
    }

    private void swap(int[] nums, int start, int end) {
        int tmp = nums[start];
        nums[start] = nums[end];
        nums[end] = tmp;
    }
}
// @lc code=end
