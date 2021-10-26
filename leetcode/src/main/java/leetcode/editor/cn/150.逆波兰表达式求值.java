import java.util.Objects;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=150 lang=java
 *
 * [150] 逆波兰表达式求值
 */

// @lc code=start
class Solution {
    public int evalRPN(String[] tokens) {
        // 表达式中只存在运算符和数字
        // 存放原始数字和中间计算结果
        Stack<Integer> numStack = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            String curStr = tokens[i];
            switch (curStr) {
            case "+":
                numStack = this.add(numStack);
                break;
            case "-":
                numStack = this.minu(numStack);
                break;
            case "*":
                numStack = this.multi(numStack);
                break;
            case "/":
                numStack = this.div(numStack);
                break;
            default:
                // num
                numStack.push(Integer.valueOf(curStr));
                break;
            }
        }
        return numStack.pop();
    }

    // 加法
    private Stack<Integer> add(Stack<Integer> numStack) {
        if (numStack == null || numStack.size() < 2) {
            throw new RuntimeException();
        }
        Integer num2 = numStack.pop();
        Integer num1 = numStack.pop();
        numStack.push(num1 + num2);
        return numStack;
    }

    // 减法
    private Stack<Integer> minu(Stack<Integer> numStack) {
        if (numStack == null || numStack.size() < 2) {
            throw new RuntimeException();
        }
        Integer num2 = numStack.pop();
        Integer num1 = numStack.pop();
        numStack.push(num1 - num2);
        return numStack;
    }

    // 乘法
    private Stack<Integer> multi(Stack<Integer> numStack) {
        if (numStack == null || numStack.size() < 2) {
            throw new RuntimeException();
        }
        Integer num2 = numStack.pop();
        Integer num1 = numStack.pop();
        numStack.push(num1 * num2);
        return numStack;
    }

    // 除法
    private Stack<Integer> div(Stack<Integer> numStack) {
        if (numStack == null || numStack.size() < 2) {
            throw new RuntimeException();
        }
        Integer num2 = numStack.pop();
        Integer num1 = numStack.pop();
        numStack.push(num1 / num2);
        return numStack;
    }
}
// @lc code=end
