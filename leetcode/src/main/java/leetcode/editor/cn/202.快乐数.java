/*
 * @lc app=leetcode.cn id=202 lang=java
 *
 * [202] 快乐数
 */

// @lc code=start
class Solution {
    public boolean isHappy(int n) {
        // 已经找过某个数字
        Set<Integer> visit = new HashSet<>();
        while (n != 1 && !visit.contains(n)) {
            visit.add(n);
            n = this.getNextNum(n);
        }
        return n == 1;
    }

    // num各个位上数字平方和
    private int getNextNum(int num) {
        int res = 0;
        while (num != 0) {
            // 低位到高位求平方
            int lowVal = num % 10;
            res += (lowVal * lowVal);
            num /= 10;
        }
        return res;
    }
}
// @lc code=end
