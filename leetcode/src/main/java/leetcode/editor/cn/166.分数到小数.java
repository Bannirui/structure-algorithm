/*
 * @lc app=leetcode.cn id=166 lang=java
 *
 * [166] 分数到小数
 */

// @lc code=start
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        // 转long类型
        long numeratorLong = (long) numerator;
        long denominatorLong = (long) denominator;
        // 整除
        if (numeratorLong % denominatorLong == 0) {
            return String.valueOf(numeratorLong / denominatorLong);
        }
        // 结果拼接
        StringBuilder sb = new StringBuilder();
        // 正负
        if (numerator < 0 ^ denominator < 0) {
            sb.append("-");
        }
        // 整数部分
        numeratorLong = Math.abs(numeratorLong);
        denominatorLong = Math.abs(denominatorLong);
        long part1 = numeratorLong / denominatorLong;
        sb.append(part1);
        sb.append(".");
        // 小数部分
        StringBuilder part2 = new StringBuilder();
        // 分子 索引
        Map<Long, Integer> visited = new HashMap<>();
        long remain = numeratorLong % denominatorLong;
        int idx = 0;
        while (remain != 0 && !visited.containsKey(remain)) {
            visited.put(remain, idx);
            remain *= 10;
            part2.append(remain / denominatorLong);
            remain %= denominatorLong;
            idx++;
        }
        // 无限循环
        if (remain != 0) {
            int insertIdx = visited.get(remain);
            part2.insert(insertIdx, "(");
            part2.append(")");
        }
        // 小数部分拼接到结果中
        sb.append(part2);
        return sb.toString();
    }
}
// @lc code=end
