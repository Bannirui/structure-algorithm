import java.util.Stack;

/*
 * @Author: dingRui
 * @Date: 2021-08-23 19:37:06
 * @LastEditors: dingRui
 * @LastEditTime: 2021-08-23 22:24:57
 * @Description: 
 */
/*
 * @lc app=leetcode.cn id=394 lang=java
 *
 * [394] 字符串解码
 */

// @lc code=start
class Solution {
    public String decodeString(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        // 遍历
        // 重复次数
        int multi = 0;
        Stack<String> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);
            if (curChar >= '0' && curChar <= '9') {
                // 数字
                multi = multi * 10 + (curChar - '0');
            } else if (curChar == '[') {
                // [
                numStack.push(multi);
                strStack.push(sb.toString());
                multi = 0;
                sb = new StringBuilder();
            } else if (curChar == ']') {
                // ]
                StringBuilder tmp = new StringBuilder();
                int curNum = numStack.pop();
                for (int j = 0; j < curNum; j++) {
                    tmp.append(sb);
                }
                sb = new StringBuilder(strStack.pop() + tmp);
            } else {
                // 字母
                sb.append(curChar);
            }
        }
        return sb.toString();
    }
}
// @lc code=end
