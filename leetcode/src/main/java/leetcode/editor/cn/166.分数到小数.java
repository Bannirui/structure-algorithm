import java.util.HashMap;
import java.util.Map;

/*
 * @Author: dingrui
 * @Date: 2021-07-28 16:45:22
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-29 11:18:48
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=166 lang=java
 *
 * [166] 分数到小数
 */

// @lc code=start
class Solution {

    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        // 判断正负号
        if ((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0)) {
            // 相除结果是负数
            res.append("-");
        }
        // 绝对值相除结果
        long numeratorAbs = Math.abs(Long.valueOf(numerator));
        long denominatorAbs = Math.abs(Long.valueOf(denominator));
        res.append(numeratorAbs / denominatorAbs);
        // 余数
        long remain = numeratorAbs % denominatorAbs;
        // 刚好除尽
        if (remain == 0) {
            return res.toString();
        }
        // 小数点
        res.append(".");
        // key=余数 value=当前余数对应商结果中的脚标
        Map<Long, Integer> indexMap = new HashMap<>();
        while (remain != 0) {
            if (indexMap.containsKey(remain)) {
                // 循环
                res.insert(indexMap.get(remain), "(");
                res.append(")");
                break;
            }
            // 把当前余数对应商的脚标放到hash表
            indexMap.put(remain, res.length());
            remain *= 10;
            res.append(String.valueOf(remain / denominatorAbs));
            remain %= denominatorAbs;
        }
        return res.toString();
    }
}
// @lc code=end
