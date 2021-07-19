/*
 * @Author: dingrui
 * @Date: 2021-07-19 09:22:02
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-19 13:49:50
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=31 lang=java
 *
 * [31] 下一个排列
 */

// @lc code=start
class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        // 最大排列: 降序
        // 从后往前找到最后一段升序
        int destIndex = -1;
        for (int i = nums.length - 1; i >= 1; i--) {
            if (nums[i - 1] < nums[i]) {
                // 找到了
                destIndex = i;
                break;
            }
        }
        destIndex--;
        if (destIndex >= 0) {
            // [destIndex...]第一个比自己大的数
            int biggerIndex = nums.length - 1;
            while (biggerIndex >= 0) {
                if (nums[biggerIndex] > nums[destIndex]) {
                    // 找到了
                    break;
                }
                biggerIndex--;
            }
            this.swap(nums, destIndex, biggerIndex);
            this.reverse(nums, destIndex + 1, nums.length - 1);
        } else {
            this.reverse(nums, 0, nums.length - 1);
        }
    }

    private void reverse(int[] nums, int l, int r) {
        while (l < r) {
            this.swap(nums, l, r);
            l++;
            r--;
        }
    }

    private void swap(int[] nums, int l, int r) {
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }
}
// @lc code=end
