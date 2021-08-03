
/*
 * @Author: dingRui
 * @Date: 2021-08-02 15:12:59
 * @LastEditors: dingRui
 * @LastEditTime: 2021-08-03 15:22:37
 * @Description: 
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * @lc app=leetcode.cn id=241 lang=java
 *
 * [241] 为运算表达式设计优先级
 */

// @lc code=start
class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        // 递归
        // base case
        if (expression == null || expression.length() == 0) {
            return Collections.emptyList();
        }
        List<Integer> res = new ArrayList<>();
        // 遍历表达式 以运算符为分割
        for (int i = 0; i < expression.length(); i++) {
            char curChar = expression.charAt(i);
            if (curChar == '+' || curChar == '-' || curChar == '*') {
                // 左边表达式
                String leftExpression = expression.substring(0, i);
                // 右边表达式
                String rightExpression = expression.substring(i + 1);
                // 左边的表达式计算结果
                List<Integer> leftRes = diffWaysToCompute(leftExpression);
                // 右边的表达式计算结果
                List<Integer> rightRes = diffWaysToCompute(rightExpression);
                // 汇总结果
                for (int leftNum : leftRes) {
                    for (int rightNum : rightRes) {
                        if (curChar == '+') {
                            res.add(leftNum + rightNum);
                        } else if (curChar == '-') {
                            res.add(leftNum - rightNum);
                        } else if (curChar == '*') {
                            res.add(leftNum * rightNum);
                        } else {
                            // 题目限定不存在其他情况
                        }
                    }
                }
            }
        }
        // 表达式本身可能被分割成单个数字
        if (res.isEmpty()) {
            res.add(Integer.valueOf(expression));
        }
        return res;
    }
}
// @lc code=end
