import java.util.Deque;
import java.util.LinkedList;

/*
 * @Author: dingRui
 * @Date: 2021-08-28 17:02:43
 * @LastEditors: dingRui
 * @LastEditTime: 2021-08-30 15:29:50
 * @Description: 
 */
/*
 * @lc app=leetcode.cn id=402 lang=java
 *
 * [402] 移掉 K 位数字
 */

// @lc code=start
class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> dq = new LinkedList<Character>();
        for (int i = 0; i < num.length(); i++) {
            char curChar = num.charAt(i);
            while (!dq.isEmpty() && k > 0 && dq.peekLast() > curChar) {
                // 可以移除 用当前cur替代last的占位
                dq.pollLast();
                k--;
            }
            dq.offerLast(curChar);
        }

        // k是否还有剩余量
        for (int i = 0; i < k; i++) {
            dq.pollLast();
        }

        // 拼接字符串
        StringBuilder sb = new StringBuilder();
        // 是否允许0 不要前导0
        boolean approveZero = false;
        while (!dq.isEmpty()) {
            char cur = dq.pollFirst();
            if (!approveZero && cur == '0') {
                continue;
            }
            approveZero = true;
            sb.append(cur);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
// @lc code=end
