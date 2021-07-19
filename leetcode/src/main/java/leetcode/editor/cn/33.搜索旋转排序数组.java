/*
 * @Author: dingrui
 * @Date: 2021-07-19 13:50:35
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-19 14:09:26
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        // 时间复杂度lgN
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        return this.bst(nums, target);
    }

    // 二分
    private int bst(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + ((r - l) >>> 1);
            if (nums[mid] == target) {
                // 找到了
                return mid;
            }
            if (nums[l] <= nums[mid]) {
                // 左边有序
                if (nums[l] <= target && target < nums[mid]) {
                    // 肯定在左边
                    r = mid - 1;
                } else {
                    // 右边
                    l = mid + 1;
                }
            } else {
                // 右边有序
                if (nums[mid] < target && target <= nums[r]) {
                    // 右边
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}
// @lc code=end
