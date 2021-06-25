import java.util.Stack;

/*
 * @Author: dingrui
 * @Date: 2021-06-25 16:20:01
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-25 16:29:09
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=844 lang=java
 *
 * [844] 比较含退格的字符串
 */

// @lc code=start
class Solution {
    public boolean backspaceCompare(String s, String t) {
        // 两个栈入字符+操作 再出栈比较
        Stack<Character> sStack = new Stack<>();
        Stack<Character> tStack = new Stack<>();
        // s
        for (int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);
            if (curChar == '#') {
                // 删除字符
                if (!sStack.isEmpty()) {
                    sStack.pop();
                }
            } else {
                sStack.push(curChar);
            }
        }
        // t
        for (int i = 0; i < t.length(); i++) {
            char curChar = t.charAt(i);
            if (curChar == '#') {
                // 删除字符
                if (!tStack.isEmpty()) {
                    tStack.pop();
                }
            } else {
                tStack.push(curChar);
            }
        }
        // 比较
        if (sStack.isEmpty() && tStack.isEmpty()) {
            return true;
        }
        if (!sStack.isEmpty() && !tStack.isEmpty() && sStack.size() == tStack.size()) {
            while (!sStack.isEmpty()) {
                if (sStack.pop() != tStack.pop()) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
// @lc code=end
