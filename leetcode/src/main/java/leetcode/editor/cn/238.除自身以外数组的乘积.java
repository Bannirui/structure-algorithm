/*
 * @lc app=leetcode.cn id=238 lang=java
 *
 * [238] 除自身以外数组的乘积
 */

// @lc code=start
class Solution {
    public int[] productExceptSelf(int[] nums) {
        // 前缀 后缀乘积
        int len = nums.length;
        int[] L = new int[len];
        int[] R = new int[len];
        int[] res = new int[len];
        // 前缀
        L[0] = 1;
        for (int i = 1; i < len; i++) {
            L[i] = L[i - 1] * nums[i - 1];
        }
        // 后缀
        R[len - 1] = 1;
        for (int i = len - 2; i >= 0; i--) {
            R[i] = R[i + 1] * nums[i + 1];
        }
        // 乘积
        for (int i = 0; i < len; i++) {
            res[i] = L[i] * R[i];
        }
        return res;
    }
}
// @lc code=end
