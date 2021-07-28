/*
 * @Author: dingrui
 * @Date: 2021-07-28 15:56:45
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-28 16:16:35
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=162 lang=java
 *
 * [162] 寻找峰值
 */

// @lc code=start
class Solution {
    public int findPeakElement(int[] nums) {
        return this.bst(nums, 0, nums.length - 1);
    }

    private int bst(int[] nums, int left, int right) {
        // base case
        if (left == right) {
            return left;
        }
        int mid = left + ((right - left) >> 1);
        if (nums[mid] > nums[mid + 1]) {
            // [mid...mid+1]降序 在[l...mid]一定有个升序
            return bst(nums, left, mid);
        } else {
            // [mid...mid+1]升序 在[mid+1...r]一定有个降序
            return bst(nums, mid + 1, right);
        }
    }
}
// @lc code=end
