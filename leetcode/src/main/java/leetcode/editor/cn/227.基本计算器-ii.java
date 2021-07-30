import java.util.Stack;

/*
 * @Author: dingrui
 * @Date: 2021-07-30 09:16:34
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-30 17:13:55
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=227 lang=java
 *
 * [227] 基本计算器 II
 */

// @lc code=start
class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int curNum = 0;
        char preOp = '+';
        for (int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);
            if (Character.isDigit(curChar)) {
                // 数字
                curNum = curNum * 10 + curChar - '0';
            }
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == s.length() - 1) {
                // 运算符
                switch (preOp) {
                case '+':
                    stack.push(curNum);
                    break;
                case '-':
                    stack.push(-curNum);
                    break;
                case '*':
                    stack.push(stack.pop() * curNum);
                    break;
                case '/':
                    stack.push(stack.pop() / curNum);
                    break;

                }
                curNum = 0;
                preOp = s.charAt(i);
            }
        }
        // stack中元素求和
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }
}
// @lc code=end
