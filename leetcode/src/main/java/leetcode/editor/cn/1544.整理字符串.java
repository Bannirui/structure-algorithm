import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/*
 * @Author: dingrui
 * @Date: 2021-07-09 14:55:04
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-09 15:14:42
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1544 lang=java
 *
 * [1544] 整理字符串
 */

// @lc code=start
class Solution {
    public String makeGood(String s) {
        // 队列
        Deque<Character> helpQueue = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (helpQueue.isEmpty()) {
                helpQueue.offerLast(s.charAt(i));
            } else {
                if (this.isConvertLowerAndUpper(s.charAt(i), helpQueue.peekLast())) {
                    helpQueue.pollLast();
                } else {
                    helpQueue.offerLast(s.charAt(i));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!helpQueue.isEmpty()) {
            sb.append(helpQueue.pollFirst());
        }
        return sb.toString();
    }

    // true:互为大小写
    private boolean isConvertLowerAndUpper(char l, char u) {
        // l小写 u大写
        if (l - 'a' >= 0 && 'z' - l >= 0 && u - 'A' >= 0 && 'Z' - u >= 0) {
            if (l - 'a' + 'A' == u) {
                return true;
            }
        }
        // l大写 u小写
        if (l - 'A' >= 0 && 'Z' - l >= 0 && u - 'a' >= 0 && 'z' - u >= 0) {
            if (l - 'A' + 'a' == u) {
                return true;
            }
        }
        return false;
    }
}
// @lc code=end
