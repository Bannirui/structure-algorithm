import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

/*
 * @Author: dingrui
 * @Date: 2021-07-21 14:59:45
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-21 15:25:01
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=71 lang=java
 *
 * [71] 简化路径
 */

// @lc code=start
class Solution {
    public String simplifyPath(String path) {
        // 分割字符串 双端队列
        String[] pathArr = path.split("\\/");
        Deque<String> q = new LinkedList<>();
        for (String curPath : pathArr) {
            if (curPath.length() == 0) {
                // 空串
                continue;
            } else if (Objects.equals(".", curPath)) {
                // .
                continue;
            } else if (Objects.equals("..", curPath)) {
                // ..
                if (!q.isEmpty()) {
                    q.pollLast();
                }
            } else {
                // 其余情况
                q.offerLast(curPath);
            }
        }
        // 收集结果
        StringBuilder sb = new StringBuilder();
        sb.append("/");
        while (!q.isEmpty()) {
            sb.append(q.pollFirst());
            if (q.size() != 0) {
                sb.append("/");
            }
        }
        return sb.toString();
    }
}
// @lc code=end
