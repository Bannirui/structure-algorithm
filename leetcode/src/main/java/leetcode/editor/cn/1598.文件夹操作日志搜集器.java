import java.util.Objects;
import java.util.Stack;

/*
 * @Author: dingrui
 * @Date: 2021-07-10 09:51:59
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-10 09:57:49
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1598 lang=java
 *
 * [1598] 文件夹操作日志搜集器
 */

// @lc code=start
class Solution {
    public int minOperations(String[] logs) {
        // 栈
        Stack<String> helpStack = new Stack<>();
        for (String log : logs) {
            if (Objects.equals(log, "../")) {
                if (!helpStack.isEmpty()) {
                    helpStack.pop();
                }
            } else if (Objects.equals(log, "./")) {
                // pass
            } else {
                helpStack.push(log);
            }
        }
        return helpStack.size();
    }
}
// @lc code=end
