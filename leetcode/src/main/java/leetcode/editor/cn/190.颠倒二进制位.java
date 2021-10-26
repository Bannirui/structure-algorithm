/*
 * @lc app=leetcode.cn id=190 lang=java
 *
 * [190] 颠倒二进制位
 */

// @lc code=start
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        // 32位
        for (int i = 0; i < 32; i++) {
            // n的最低位
            int last = n & 1;
            n >>>= 1;
            // 最后一位挂到res中
            last <<= (31 - i);
            res |= last;
        }
        return res;
    }
}
// @lc code=end
