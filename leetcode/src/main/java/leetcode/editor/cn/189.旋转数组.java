import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=189 lang=java
 *
 * [189] 旋转数组
 */

// @lc code=start
class Solution {
    public void rotate(int[] nums, int k) {
        // 暴力法
        // this.force(nums, k);

        // 翻转
        k %= nums.length;
        this.reverse(nums, 0, nums.length - 1);
        // 翻转前k个
        this.reverse(nums, 0, k - 1);
        // 翻转后n-k个
        this.reverse(nums, k, nums.length - 1);
    }

    // nums中[start...end]翻转
    private void reverse(int[] nums, int start, int end) {
        // [start...end]翻转
        while (start < end) {
            int startVal = nums[start];
            nums[start] = nums[end];
            nums[end] = startVal;
            start++;
            end--;
        }
    }

    private void force(int[] nums, int k) {
        // 移动的元素数量
        int len = nums.length;
        k %= len;
        // 模拟
        while (k != 0) {
            k--;
            // 模拟一次
            this.rotate2right(nums);
        }
    }

    private void rotate2right(int[] nums) {
        // 最后一个元素
        int len = nums.length;
        int last = nums[len - 1];
        for (int i = len - 1; i >= 1; i--) {
            nums[i] = nums[i - 1];
        }
        nums[0] = last;
    }
}
// @lc code=end
