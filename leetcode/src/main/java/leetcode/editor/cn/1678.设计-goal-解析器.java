import java.util.Deque;
import java.util.LinkedList;

/*
 * @Author: dingrui
 * @Date: 2021-07-11 16:32:35
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-11 16:41:12
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1678 lang=java
 *
 * [1678] 设计 Goal 解析器
 */

// @lc code=start
class Solution {
    public String interpret(String command) {
        // 双端队列
        Deque<Character> dq = new LinkedList<>();
        for (int i = 0; i < command.length(); i++) {
            char cur = command.charAt(i);
            if (cur == ')') {
                if (dq.peekLast() == '(') {
                    dq.pollLast();
                    dq.offerLast('o');
                } else {
                    for (int j = 0; j < 3; j++) {
                        dq.pollLast();
                    }
                    dq.offerLast('a');
                    dq.offerLast('l');
                }
            } else {
                dq.offerLast(cur);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!dq.isEmpty()) {
            sb.append(dq.pollFirst());
        }
        return sb.toString();
    }
}
// @lc code=end
