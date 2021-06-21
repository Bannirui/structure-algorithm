/*
 * @Author: dingrui
 * @Date: 2021-06-21 15:28:00
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-21 15:39:14
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=682 lang=java
 *
 * [682] 棒球比赛
 */

// @lc code=start
class Solution {
    public int calPoints(String[] ops) {
        int res = 0;
        // base case
        if (ops == null || ops.length == 0) {
            return res;
        }
        // 遍历 每一次得分放到栈顶
        Stack<Integer> stack = new Stack<>();
        for (int index = 0; index < ops.length; index++) {
            String s = ops[index];
            if (s.equals("C")) {
                // C 弹出栈顶元素
                stack.pop();
            } else if (s.equals("D")) {
                // D 栈顶元素的两倍
                int top = stack.peek();
                stack.push(top << 1);
            } else if (s.equals("+")) {
                // + 栈顶2元素之和
                int topFir = stack.pop();
                int topSec = stack.peek();
                int sum = topFir + topSec;
                stack.push(topFir);
                stack.push(sum);
            } else {
                // 数字
                stack.push(Integer.parseInt(s));
            }
        }
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}
// @lc code=end
