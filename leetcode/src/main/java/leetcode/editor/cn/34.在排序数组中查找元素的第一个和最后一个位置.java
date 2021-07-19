/*
 * @Author: dingrui
 * @Date: 2021-07-19 14:10:53
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-19 14:43:17
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        // 二分
        if (nums.length == 0) {
            return new int[] { -1, -1 };
        }
        if (nums.length == 1) {
            return nums[0] == target ? new int[] { 0, 0 } : new int[] { -1, -1 };
        }
        int minIndex = this.bst(nums, target, true);
        int maxIndex = this.bst(nums, target, false);
        return new int[] { minIndex, maxIndex };
    }

    // 二分
    private int bst(int[] nums, int target, boolean lower) {
        int index = -1;
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + ((r - l) >>> 1);
            if (nums[mid] == target) {
                // 找到了 更新脚标
                index = mid;
                if (lower) {
                    // 找更小的 左边
                    r = mid - 1;
                } else {
                    // 找更大的 右边
                    l = mid + 1;
                }
            }
            if (nums[mid] < target) {
                // 找右边
                l = mid + 1;
            }
            if (nums[mid] > target) {
                // 找左边
                r = mid - 1;
            }
        }
        return index;
    }
}
// @lc code=end
