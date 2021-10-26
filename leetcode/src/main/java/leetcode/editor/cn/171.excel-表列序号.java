/*
 * @lc app=leetcode.cn id=171 lang=java
 *
 * [171] Excel 表列序号
 */

// @lc code=start
class Solution {
    public int titleToNumber(String columnTitle) {
        // 进制转换
        // base case
        if (columnTitle == null || columnTitle.length() == 0) {
            return 0;
        }
        return this.calStrPeriod(columnTitle, 0, columnTitle.length() - 1);
    }

    // 进制转换 str[from...to]
    private int calStrPeriod(String str, int from, int to) {
        // base case
        if (from > to) {
            return 0;
        }
        char lastChar = str.charAt(to);
        int lastVal = (lastChar - 'A') + 1;
        // 进制是26
        return this.calStrPeriod(str, from, to - 1) * 26 + lastVal;
    }
}
// @lc code=end
