/*
 * @lc app=leetcode.cn id=371 lang=java
 *
 * [371] 两整数之和
 */

// @lc code=start
class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
            // 进位
            int carry = (a & b) << 1;
            // 无进位的求和
            int sum = a ^ b;
            a = sum;
            b = carry;
        }
        return a;
    }
}
// @lc code=end
