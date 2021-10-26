/*
 * @lc app=leetcode.cn id=172 lang=java
 *
 * [172] 阶乘后的零
 */

// @lc code=start
class Solution {
    public int trailingZeroes(int n) {
        // 统计[1...n]中5的倍数数量
        return this.countOf5(n);
    }

    private int countOf5(int n) {
        int cnt = 0;
        for (int i = 5; i <= n; i += 5) {
            int cur = i;
            while (cur % 5 == 0) {
                cnt++;
                cur /= 5;
            }
        }
        return cnt;
    }
}
// @lc code=end
