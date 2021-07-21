/*
 * @Author: dingrui
 * @Date: 2021-07-21 20:44:39
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-21 21:58:34
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=81 lang=java
 *
 * [81] 搜索旋转排序数组 II
 */

// @lc code=start
class Solution {
    public boolean search(int[] nums, int target) {
        if (nums.length == 0) {
            return false;
        }
        if (nums.length == 1) {
            return nums[0] == target;
        }
        // 二分
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            int cur = nums[mid];
            if (cur == target) {
                return true;
            }
            if (nums[l] == cur && cur == nums[r]) {
                l++;
                r--;
            } else if (cur <= nums[r]) {
                if (cur <= target && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } else if (nums[l] <= cur) {
                if (nums[l] <= target && target <= cur) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }
        return false;
    }
}
// @lc code=end
