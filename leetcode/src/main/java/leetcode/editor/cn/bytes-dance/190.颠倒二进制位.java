/*
 * @lc app=leetcode.cn id=190 lang=java
 *
 * [190] 颠倒二进制位
 */

// @lc code=start
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ret=0;
        for(int i=0;i<32;i++){
            int t = n&1;
            n>>=1;
            ret|=(t<<(31-i));
        }
        return ret;
    }
}
// @lc code=end

