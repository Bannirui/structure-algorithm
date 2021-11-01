/*
 * @lc app=leetcode.cn id=334 lang=java
 *
 * [334] 递增的三元子序列
 */

// @lc code=start
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE;
        int mid = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num < min) {
                min = num;
            } else if (min < num && num < mid) {
                mid = num;
            } else if (num > mid) {
                // 找到了递增
                return true;
            }
        }
        return false;
    }
}
// @lc code=end
