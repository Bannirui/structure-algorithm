import java.util.Stack;

/*
 * @Author: dingrui
 * @Date: 2021-07-01 08:57:31
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-01 11:14:40
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1047 lang=java
 *
 * [1047] 删除字符串中的所有相邻重复项
 */

// @lc code=start
class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> helpStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (helpStack.isEmpty()) {
                helpStack.push(s.charAt(i));
            } else {
                if (helpStack.peek() == s.charAt(i)) {
                    helpStack.pop();
                } else {
                    helpStack.push(s.charAt(i));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!helpStack.isEmpty()) {
            sb.append(helpStack.pop());
        }
        sb.reverse();
        return sb.toString();
    }
}
// @lc code=end
