import java.util.Arrays;

/*
 * @Author: dingRui
 * @Date: 2021-08-09 11:07:56
 * @LastEditors: dingRui
 * @LastEditTime: 2021-08-09 14:50:57
 * @Description: 
 */
/*
 * @lc app=leetcode.cn id=324 lang=java
 *
 * [324] 摆动排序 II
 */

// @lc code=start
class Solution {
    public void wiggleSort(int[] nums) {
        // 中位数下标
        int midIndex = this.quickSelect(nums, 0, nums.length - 1);
        // 中位数
        int mid = nums[midIndex];
        // 三分法
        int len = nums.length;
        for (int i = 0, j = 0, k = len - 1; j <= k;) {
            int num = nums[this.virtual(j, len)];
            if (num > mid) {
                swap(nums, virtual(j++, len), virtual(i++, len));
            } else if (num < mid) {
                swap(nums, virtual(j, len), virtual(k--, len));
            } else {
                j++;
            }
        }
    }

    private int virtual(int i, int n) {
        return (1 + 2 * i) % (n | 1);
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    /**
     * 快排
     * @param nums
     * @param start
     * @param end
     * @return nums数组中位数下标
     */
    private int quickSelect(int[] nums, int left, int right) {
        // 基准
        int pivot = nums[left];
        int l = left, r = right;
        while (l < r) {
            while (l < r && nums[r] >= pivot) {
                r--;
            }
            if (l < r) {
                nums[l++] = nums[r];
            }
            while (l < r && nums[l] <= pivot) {
                l++;
            }
            if (l < r) {
                nums[r--] = nums[l];
            }
        }
        // [left...l] [l...right]相对l有序
        nums[l] = pivot;
        if (l == nums.length / 2) {
            return l;
        } else if (l > nums.length / 2) {
            return this.quickSelect(nums, left, l - 1);
        } else {
            return this.quickSelect(nums, l + 1, right);
        }
    }
}
// @lc code=end
