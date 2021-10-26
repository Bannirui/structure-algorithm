/*
 * @lc app=leetcode.cn id=191 lang=java
 *
 * [191] 位1的个数
 */

// @lc code=start
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int cnt = 0;
        for (int i = 0; i < 32 && n != 0; i++) {
            // 最后一位
            if ((n & 1) != 0) {
                cnt++;
            }
            n >>>= 1;
        }
        return cnt;
    }
}
// @lc code=end
