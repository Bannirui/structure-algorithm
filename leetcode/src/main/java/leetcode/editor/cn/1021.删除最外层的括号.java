import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 * @Author: dingrui
 * @Date: 2021-06-30 15:42:46
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-30 15:54:59
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1021 lang=java
 *
 * [1021] 删除最外层的括号
 */

// @lc code=start
class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Character> helpMap = new HashMap<>();
        helpMap.put('(', ')');
        helpMap.put(')', '(');
        Stack<Character> helpStack = new Stack<>();
        int lastIndex = 0, index = 0;
        while (index < s.length()) {
            char c = s.charAt(index);
            if (helpStack.isEmpty()) {
                helpStack.push(c);
            } else {
                if (helpStack.peek() != helpMap.get(c)) {
                    helpStack.push(c);
                } else {
                    helpStack.pop();
                }
            }
            // 收集答案
            if (helpStack.isEmpty()) {
                sb.append(s.substring(lastIndex + 1, index));
                lastIndex = index + 1;
            }
            index++;
        }
        return sb.toString();
    }
}
// @lc code=end
