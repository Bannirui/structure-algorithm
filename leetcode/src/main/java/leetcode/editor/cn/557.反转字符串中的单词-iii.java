import java.nio.channels.Pipe.SinkChannel;

/*
 * @Author: dingrui
 * @Date: 2021-06-21 10:41:51
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-21 11:30:27
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=557 lang=java
 *
 * [557] 反转字符串中的单词 III
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        // 以空格分割为字符数组 遍历依次反转 再拼接上空格
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        // 指针后移找单词
        int i = 0;
        while (i < len) {
            if (s.charAt(i) == ' ') {
                // 空格
                sb.append(" ");
                i++;
            } else {
                // 不是空格 单词区域
                int start = i;
                while (i < len && s.charAt(i) != ' ') {
                    i++;
                }
                // 现在的i就在空格上
                for (int k = start; k < i; k++) {
                    sb.append(s.charAt(start + i - 1 - k));
                }
            }
        }
        return sb.toString();
    }
}
// @lc code=end
