/*
 * @lc app=leetcode.cn id=227 lang=java
 *
 * [227] 基本计算器 II
 */

// @lc code=start
class Solution {
    public int calculate(String s) {
        // 两个栈 数字 运算符
        Stack<Integer> numStack = new Stack<>();

        char preOp = '+';
        // 字符串连续数字
        int curNum = 0;
        for (int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);
            if (Character.isDigit(curChar)) {
                // 数字
                curNum = curNum * 10 + (curChar - '0');
            }
            if ((!Character.isDigit(curChar) && s.charAt(i) != ' ') || (i == s.length() - 1)) {
                // 运算符
                switch (preOp) {
                case '+':
                    numStack.push(curNum);
                    break;
                case '-':
                    numStack.push(-curNum);
                    break;
                case '*':
                    numStack.push(numStack.pop() * curNum);
                    break;
                case '/':
                    numStack.push(numStack.pop() / curNum);
                    break;
                default:
                    break;
                }
                preOp = curChar;
                curNum = 0;
            }

        }
        // 栈中数求和
        int sum = 0;
        while (!numStack.isEmpty()) {
            sum += numStack.pop();
        }
        return sum;
    }
}
// @lc code=end
