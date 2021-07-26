/*
 * @Author: dingrui
 * @Date: 2021-07-26 15:06:06
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-26 15:39:18
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=150 lang=java
 *
 * [150] 逆波兰表达式求值
 */

// @lc code=start
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (this.isDigit(token)) {
                // 数字
                stack.push(Integer.parseInt(token));
            } else {
                // 运算符
                // 后进
                int num1 = stack.pop();
                // 先进
                int num2 = stack.pop();
                if ("+".equals(token)) {
                    // +
                    stack.push(num2 + num1);
                } else if ("-".equals(token)) {
                    // -
                    stack.push(num2 - num1);
                } else if ("*".equals(token)) {
                    // *
                    stack.push(num2 * num1);
                } else {
                    // /
                    stack.push(num2 / num1);
                }
            }
        }
        return stack.peek();
    }

    // 字符串s是否是数字
    private boolean isDigit(String s) {
        return !("+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s));
    }
}
// @lc code=end
