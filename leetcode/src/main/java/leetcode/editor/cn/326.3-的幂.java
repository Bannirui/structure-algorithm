/*
 * @lc app=leetcode.cn id=326 lang=java
 *
 * [326] 3的幂
 */

// @lc code=start
class Solution {
    public boolean isPowerOfThree(int n) {
        // 递归 问题规模逼近0
        // base case
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        // 肯定得是3的倍数
        int mod = n % 3;
        if (mod != 0) {
            return false;
        }
        int div = n / 3;
        // 问题规模缩小到div
        return this.isPowerOfThree(div);
    }
}
// @lc code=end
