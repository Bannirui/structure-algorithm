/*
 * @Author: dingrui
 * @Date: 2021-07-28 15:10:37
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-28 15:29:38
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=151 lang=java
 *
 * [151] 翻转字符串里的单词
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        // stack中逐个放单词
        Stack<String> stack = new Stack<>();
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                // 遇到空格 收集单词
                if (word.length() != 0) {
                    stack.push(word.toString());
                    word = new StringBuilder();
                }
            } else {
                word.append(s.charAt(i));
            }
        }
        // 收集单词的时机是在遇到空格
        if (word.length() != 0) {
            stack.push(word.toString());
        }
        StringBuilder sb = new StringBuilder();
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            sb.append(stack.pop());
            if (i != size - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
// @lc code=end
